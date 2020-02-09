package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

//need initializable for button
public class Controller implements Initializable {

    @FXML
    private ListView<Employee> employeeListView;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private CheckBox isActiveCheckBox;


    //implement initializable but we're not happy with default so we're modifying and thus overriding
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        employeeListView.getSelectionModel().selectedItemProperty().addListener((
                ObservableValue < ? extends Worker> ov, Worker old_val, Worker new_val)->
        {
            Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();

            firstNameTextField.setText(((Employee)selectedItem).firstName);
            lastNameTextField.setText(((Employee)selectedItem).lastName);
            isActiveCheckBox.setSelected(((Employee)selectedItem).isActive);
            //typecast in a try catch block
        });

        ObservableList <Employee> items = employeeListView.getItems();
        Employee employee1 = new Employee();
        Employee employee2= new Employee();

        employee1.firstName = "Robert";
        employee1.lastName = "Tree";
        employee2.firstName = "Lisa";
        employee2.lastName = "Smith";

        items.add(employee1);
        items.add(employee2);


        /*ObservableList<String> items = employeeListView.getItems();
        items.add("Robert");
        items.add("Lisa");*/

        for(int i =0; i<10; i++){
            Employee employee = new Employee();
            employee.firstName = "Generic";
            employee.lastName = "Employee" + " " + i;
            employee.hire();
            items.add(employee);

        }

        Staff staff1 = new Staff();
        staff1.firstName = "StaffPerson";
        staff1.lastName = "GoodWorker";

        Faculty faculty1 = new Faculty();
        faculty1.firstName = "FacultyPerson";
        faculty1.lastName = "TerribleWorker";

        items.add(staff1);
        items.add(faculty1);
    }
}
