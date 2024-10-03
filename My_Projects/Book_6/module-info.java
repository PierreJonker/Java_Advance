module Book_6 {
    requires javafx.controls;
    requires javafx.fxml;


    exports Chapter_1;
    opens Chapter_1 to javafx.fxml;
    exports Chapter_2;
    opens Chapter_2 to javafx.fxml;
    exports Chapter_3;
    opens Chapter_3 to javafx.fxml;
    exports Chapter_4;
    opens Chapter_4 to javafx.fxml;
    exports Chapter_5;
    opens Chapter_5 to javafx.fxml;
    exports Chapter_6;
    opens Chapter_6 to javafx.fxml;
}