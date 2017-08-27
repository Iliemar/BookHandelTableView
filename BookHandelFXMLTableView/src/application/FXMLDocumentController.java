/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author Marius
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private TableView<Book> bookTable;
    @FXML private TableColumn<Book,String>Name;
    @FXML private TableColumn<Book,String>ISBN;
    @FXML private TableColumn<Book,String>Antal;
     @FXML private TableColumn<Book,String>Pris;
     
    @FXML
    TextField n;
    
    @FXML
    TextField i;
    
    @FXML
    TextField a;
    
     @FXML
    TextField p;
     
     @FXML
    private Button add;
     
       @FXML
    private Button remove;
    
    
    public ObservableList<Book>list=FXCollections.observableArrayList(
            new Book("Java FX","123456","13","1000kr"),
            new Book("MSQL Tutorial","93763533","20","800kr"),
            new Book ("C# Step By Step","45378955","14","600kr") );

   
            
    @FXML
    private void ButtonAction(ActionEvent event)
    {
       list.add(new Book(n.getText(),i.getText(),a.getText(),p.getText()));
       n.clear();
       i.clear();
       a.clear();
        p.clear();
    }
    @FXML
    private void deleteBook(ActionEvent d) {
        Book selected = bookTable.getSelectionModel().getSelectedItem();
        if (selected != null) 
        {
            list.remove(selected);
            System.out.println("Delete succeeded");
        } else
        {
            System.out.println("Please select something before deleting");
        }
    }
    
// för att Edita saker i listan
@FXML
    private void handleEditActionName(CellEditEvent<Book, String> t)
    {
        ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
    }
	
	
	 @FXML
    private void handleEditActionISBN(CellEditEvent<Book, String> t) 
    {
        ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setISBN(t.getNewValue());
    }
	
	
	 @FXML
    private void handleEditActionAntal(CellEditEvent<Book, String> t)
    {
        ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAntal(t.getNewValue());
    }
	
	
	 @FXML
    private void handleEditActionPris(CellEditEvent<Book, String> t) 
    {
        ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPris(t.getNewValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Name.setCellValueFactory(new PropertyValueFactory<Book,String>("Name"));  
        ISBN.setCellValueFactory(new PropertyValueFactory<Book,String>("ISBN"));
        Antal.setCellValueFactory(new PropertyValueFactory<Book,String>("Antal"));
        Pris.setCellValueFactory(new PropertyValueFactory<Book,String>("Pris"));
       
        bookTable.setItems(list);
// för att byta namn 
        Name.setCellFactory(TextFieldTableCell.forTableColumn());
        ISBN.setCellFactory(TextFieldTableCell.forTableColumn());
        Antal.setCellFactory(TextFieldTableCell.forTableColumn());
        Pris.setCellFactory(TextFieldTableCell.forTableColumn());
        
       
         bookTable.setEditable(true);
      
        Name.setEditable(true);
        ISBN.setEditable(true);
        Antal.setEditable(true);
        Pris.setEditable(true);

        
    } 
    
}
