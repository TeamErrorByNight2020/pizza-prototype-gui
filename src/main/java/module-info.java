module io.github.teamerrorbynight2020 {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens io.github.teamerrorbynight2020 to javafx.fxml;
    exports io.github.teamerrorbynight2020;
}