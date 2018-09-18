import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.DecimalFormat;

public class calculator extends Application{
    //creates new text box
    private TextField tf = new TextField();

    //creates buttons for calculator
    private Button bAdd = new Button("+");
    private Button bEquals = new Button("=");
    private Button bSub = new Button("-");
    private Button bMult = new Button("*");
    private Button bDiv = new Button("/");

    private Button bClear=new Button("AC");
    private Button bDecimal= new Button(".");
    private Button bNegative=new Button("±");

    private Button b0 = new Button("0");
    private Button b1=new Button("1");
    private Button b2 = new Button("2");
    private Button b3 = new Button("3");
    private Button b4 = new Button("4");
    private Button b5 = new Button("5");
    private Button b6 = new Button("6");
    private Button b7 = new Button("7");
    private Button b8 = new Button("8");
    private Button b9 = new Button("9");

    //used to control operations
    private int operation=-1;
    //used to store answers
    private double ans;
    //used to store num1 and num2 from mouse input
    private double num1;
    private double num2;


    //Used to control calculator operations of buttons pressed
    private void btnOperations(ActionEvent e){
        //used to control operation if certain buttons pressed
        if(e.getSource()==bDecimal){
            String s=tf.getText();
            if(s.contains(".")){
                tf.setText(s);
            }
            else tf.setText(tf.getText() + ".");
        }
        else if (e.getSource() == bAdd) {
            num1 = Double.parseDouble(tf.getText());
            tf.setText("");
            operation = 0;
        }
        else if (e.getSource() == bSub) {
            num1 = Double.parseDouble(tf.getText());
            tf.setText("");
            operation = 1;
        }
        else if (e.getSource() == bMult) {
            num1 = Double.parseDouble(tf.getText());
            tf.setText("");
            operation = 2;
        }
        else if (e.getSource() == bDiv) {
            num1 = Double.parseDouble(tf.getText());
            tf.setText("");
            operation = 3;
        }
        else if (e.getSource() == bEquals) {
            num2 = Double.parseDouble(tf.getText());
            DecimalFormat df =new DecimalFormat("#########.#####");
            if (operation == 0) {
                ans = num1 + num2;
                tf.setText(df.format(ans));
            }
            else if (operation == 1) {
                ans = num1 - num2;
                tf.setText(df.format(ans));

            }
            else if (operation == 2) {
                ans = num1 * num2;
                tf.setText(df.format(ans));
            }
            else if (operation == 3) {
                //Prints error if dividing by 0
                if(num2==0 && num1!=0){
                    tf.setText("Error");
                }
                tf.setText(df.format(ans));
                //Handles Exception due to 0 on button
                try {
                    ans = num1 / num2;
                }
                catch (IllegalArgumentException ex) {
                    tf.setText("Error");
                }
            }
        }
        else if(e.getSource()==bClear){
            tf.setText("");
        }
        else if(e.getSource()==bNegative){
            String s1=tf.getText();
            //Makes numbers negative
            if(tf.getText().contains("") && !tf.getText().contains("-")){
                String s2="-";
                String s3=s2.concat(s1);
                tf.setText(s3);
            }
            //makes numbers positive if negative pressed
            else if(tf.getText().contains("-")){
                String s2=tf.getText();
                s2=s2.replace("-", "");
                tf.setText(s2);
            }
        }
    }
    private void bNumbers(ActionEvent e){
        //Prints text of numbers on textbox of numbers pressed
        if(e.getSource()==b0){
            tf.setText(tf.getText() + "0");
        }
        else if(e.getSource()==b1){
            tf.setText(tf.getText() + "1");
        }
        else if(e.getSource()==b2){
            tf.setText(tf.getText() + "2");
        }
        else if(e.getSource()==b3){
            tf.setText(tf.getText() + "3");
        }
        else if(e.getSource()==b4){
            tf.setText(tf.getText() + "4");
        }
        else if(e.getSource()==b5){
            tf.setText(tf.getText() + "5");
        }
        else if(e.getSource()==b6){
            tf.setText(tf.getText() + "6");
        }
        else if(e.getSource()==b7){
            tf.setText(tf.getText() + "7");
        }
        else if(e.getSource()==b8){
            tf.setText(tf.getText() + "8");
        }
        else if(e.getSource()==b9){
            tf.setText(tf.getText() + "9");
        }
    }
    public void start(Stage primaryStage) {
        //Crates name of program on stage as Calculator
        primaryStage.setTitle("Calculator");

        //Sets sizes for buttons
        int h = 400;
        int w = 400;

        //Sets the buttons alignment and style
        b0.setMaxSize(h ,w);
        b0.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");
        b0.setAlignment(Pos.CENTER);

        b1.setMaxSize(w, h);
        b1.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        b2.setMaxSize(w, h);
        b2.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        b3.setMaxSize(w, h);
        b3.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        b4.setMaxSize(w, h);
        b4.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        b5.setMaxSize(w, h);
        b5.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        b6.setMaxSize(w, h);
        b6.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        b7.setMaxSize(w, h);
        b7.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        b8.setMaxSize(w, h);
        b8.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        b9.setMaxSize(w, h);
        b9.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        bAdd.setMaxSize(w, h);
        bAdd.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        bSub.setMaxSize(w, h);
        bSub.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        bMult.setMaxSize(w, h);
        bMult.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        bDiv.setMaxSize(w, h);
        bDiv.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        bEquals.setMaxSize(w, h);
        bEquals.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        bClear.setMaxSize(w,h);
        bClear.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em; ");

        bDecimal.setMaxSize(w,h);
        bDecimal.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em;");

        bNegative.setMaxSize(w,h);
        bNegative.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 5em;");

        //Creates borderpane and gridpane
        BorderPane bp = new BorderPane();
        GridPane gp=new GridPane();

        //Adds textbook to broderpane
        bp.setTop(tf);
        //sets the placement of text
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        //sets the height and width of textbox
        tf.setPrefHeight(100);
        tf.setPrefWidth(220);
        //sets the font size of textbox
        tf.setStyle("-fx-font-size: 3em;");

        //adds gridpane to the center of boarderpane
        bp.setCenter(gp);
        //add buttons to the locations of gp
        gp.add(bClear, 0,0, 2, 1);
        gp.add(bDecimal, 2,0);
        gp.add(bNegative, 3,0);


        gp.add(bAdd, 3, 1);
        gp.add(bSub, 3, 2);
        gp.add(bMult, 3, 3);
        gp.add(bDiv, 3, 4);
        gp.add(bEquals, 2, 4);

        gp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        gp.add(b0, 0, 4 , 2, 1);

        gp.add(b1, 0, 3);
        gp.add(b2, 1, 3);
        gp.add(b3, 2, 3);

        gp.add(b4, 0, 2);
        gp.add(b5, 1, 2);
        gp.add(b6, 2, 2);

        gp.add(b7, 0, 1);
        gp.add(b8, 1, 1);
        gp.add(b9, 2, 1);

        //Creates the separation between buttons
        gp.setMargin(bNegative, new Insets(20,20, 20, 20));
        gp.setMargin(bClear, new Insets(20, 20, 20, 20));
        gp.setMargin(bMult, new Insets(20, 20, 20, 20));
        gp.setMargin(bSub, new Insets(20, 20, 20, 20));
        gp.setMargin(bAdd, new Insets(20, 20, 20, 20));
        gp.setMargin(bEquals, new Insets(20, 20, 20, 20));
        gp.setMargin(bDecimal, new Insets(20, 20, 20, 20));
        gp.setMargin(bDiv, new Insets(20, 20, 20, 20));

        gp.setMargin(b0, new Insets(20, 20, 20, 20));
        gp.setMargin(b1, new Insets(20, 20, 20, 20));
        gp.setMargin(b2, new Insets(20, 20, 20, 20));
        gp.setMargin(b3, new Insets(20, 20, 20, 20));
        gp.setMargin(b4, new Insets(20, 20, 20, 20));
        gp.setMargin(b5, new Insets(20, 20, 20, 20));
        gp.setMargin(b6, new Insets(20, 20, 20, 20));
        gp.setMargin(b7, new Insets(20, 20, 20, 20));
        gp.setMargin(b8, new Insets(20, 20, 20, 20));
        gp.setMargin(b9, new Insets(20, 20, 20, 20));

        //Lambda expression that calls methods when a button is pressed
        bDecimal.setOnAction(e -> btnOperations(e));
        b0.setOnAction(e -> bNumbers(e));
        b1.setOnAction(e -> bNumbers(e));
        b2.setOnAction(e -> bNumbers(e));
        b3.setOnAction(e -> bNumbers(e));
        b4.setOnAction(e -> bNumbers(e));
        b5.setOnAction(e -> bNumbers(e));
        b6.setOnAction(e -> bNumbers(e));
        b7.setOnAction(e -> bNumbers(e));
        b8.setOnAction(e -> bNumbers(e));
        b9.setOnAction(e -> bNumbers(e));

        bClear.setOnAction(e -> btnOperations(e));
        bNegative.setOnAction(e -> btnOperations(e));

        bAdd.setOnAction(e -> btnOperations(e));
        bMult.setOnAction(e -> btnOperations(e));
        bDiv.setOnAction(e -> btnOperations(e));
        bSub.setOnAction(e -> btnOperations(e));

        bEquals.setOnAction(e -> btnOperations(e));

        //sets background color of borderpane
        bp.setStyle("-fx-background-color: #FFFFFF;");
        //sets size of scene
        Scene scene = new Scene(bp, 400, 790);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}