package io.nekopara.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NekoMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // 布局管理器
        Parent root = FXMLLoader.load(getClass().getResource("ui/nekopara.fxml"));
        // 窗口标题
        primaryStage.setTitle("Java utils");
        // 设置幕布Scene （相当于swing的JPanel 面板）
        primaryStage.setScene(new Scene(root, 900, 650));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
