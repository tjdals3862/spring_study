module com.company.ioc.ioc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.company.ioc.ioc to javafx.fxml;
    exports com.company.ioc.ioc;
}