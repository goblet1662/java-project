/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author IT-02
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 *
 * @author IT-02
 */
public class OrderBookList extends Application {
    private PreparedStatement ps;
    BookStore store=new BookStore();
    public static final String Key1 = "Id";
    public static final String Key2 = "BookName";
    public static final String Key3 = "Quantity";
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Lists of books");
        stage.setWidth(700);
        stage.setHeight(500);
        
        final Label label = new Label("Orderd Book List");
        label.setFont(new Font("Arial", 20));
 
        TableColumn<Map, String> firstDataColumn = new TableColumn<>("ID");
        TableColumn<Map, String> secondDataColumn = new TableColumn<>("BookName");
        TableColumn<Map, String> thirdDataColumn = new TableColumn<>("Quantity");
 
        firstDataColumn.setCellValueFactory(new MapValueFactory(Key1));
        firstDataColumn.setMinWidth(130);
        secondDataColumn.setCellValueFactory(new MapValueFactory(Key2));
        secondDataColumn.setMinWidth(130);
        
        thirdDataColumn.setCellValueFactory(new MapValueFactory(Key3));
        thirdDataColumn.setMinWidth(130);
 
        TableView table_view = new TableView<>(generateDataInMap());
 
        table_view.setEditable(true);
        table_view.getSelectionModel().setCellSelectionEnabled(true);
        table_view.getColumns().setAll(firstDataColumn, secondDataColumn,thirdDataColumn);
        Callback<TableColumn<Map, String>, TableCell<Map, String>>
            cellFactoryForMap = new Callback<TableColumn<Map, String>,
                TableCell<Map, String>>() {
                    @Override
                    public TableCell call(TableColumn p) {
                        return new TextFieldTableCell(new StringConverter() {
                            @Override
                            public String toString(Object t) {
                                return t.toString();
                            }
                            @Override
                            public Object fromString(String string) {
                                return string;
                            }                                    
                        });
                    }
        };
        firstDataColumn.setCellFactory(cellFactoryForMap);
        secondDataColumn.setCellFactory(cellFactoryForMap);
 
        final VBox vbox = new VBox();
 
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table_view);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
 
        stage.show();
    }
 
    private ObservableList<Map> generateDataInMap() {
        int max = 10;
        ObservableList<Map> allData = FXCollections.observableArrayList();
        Connection con;
        Statement st;
        ResultSet rs;
         try{
             con=store.Database_connection();
               ps = con.prepareStatement("select * from book_order");
               rs = ps.executeQuery();

			while (rs.next()) {

                                //list.add(rs.getString("name"));
				String id = rs.getString("id");
				String bookname = rs.getString("name");
				String quantity = rs.getString("quantity");

				System.out.println("id : " + id);
				System.out.println("bookname : " + bookname);
				
                                Map<String, String> dataRow = new HashMap<>();
            dataRow.put(Key1, id);
            dataRow.put(Key2, bookname);
            dataRow.put(Key3, quantity);
 
            allData.add(dataRow);
			}
         }catch(Exception ex){
             ex.printStackTrace();
         }
       
        return allData;
    }
}