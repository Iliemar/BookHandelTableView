/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

/**
 *
 * @author Marius
 */
public class Book {
    
    private final SimpleStringProperty Name;
    private final SimpleStringProperty ISBN;
    private final SimpleStringProperty Antal;
    private final SimpleStringProperty Pris;
    
    public Book(String name,String antal,String pris,String kvalitet){
        this.Name=new SimpleStringProperty(name);
        this.ISBN=new SimpleStringProperty(antal);
        this.Antal=new SimpleStringProperty(pris);
        this.Pris=new SimpleStringProperty(kvalitet);
        
        
    }

    

public String getName() 
    {
        return Name.get();
    }

public void setName(String n)
    {
        Name.set(n);
    }
     
  

public String getAntal() 
    {
        return Antal.get();
    }

public void setAntal(String a) 
    {
       Antal.set(a);
    }


    public String getPris()
    {
        return Pris.get();
    }

    public void setPris(String p) 
    {
        Pris.set(p);
    }
    
    public String getISBN()
    {
        return ISBN.get();
    }
    public void setISBN(String i)
    {
        ISBN.set(i);
    }
     
       public String toString() {
        return (Name.get() + " " + ISBN.get()+" "+Antal.get() + " " + Pris.get());
                
                }
    

    }
