package circles;

import static java.lang.Double.max;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * A lab #2 exercise file.
 * @author wahab
 */
public class Circles extends Application {
    
    public static final int MAX_ROWS = 5;
    public static final int MAX_COLS = 5;
    public static final int MAX_CELL_SIZE = 150;
    
    @Override
    public void start(Stage primaryStage) {
        root = new VBox(10);        
        root.setAlignment(Pos.CENTER);
        canvas = update_circles(MAX_ROWS,MAX_COLS,100,0,0);
        addButtonHandler();  // You must write

        controls_box = initialize_controls();
        
        root.getChildren().addAll(canvas,controls_box);
        
        primaryStage.setTitle("Lab #2 Exercise");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    /**
     * This method adds the handler to the button that gives
     * this application its behavior.
     */
    private void addButtonHandler() {
    }
    
    private Pane update_circles(int rows, int columns, int cell_size, int x_scale, int y_scale){
        Pane local_canvas = new Pane();
        Random rand = new Random(10);
        ArrayList<Circle> circles = new ArrayList<>();
        TranslateTransition translate;
        ScaleTransition scale;
        for (int i=0; i< columns; i++){
            for (int j=0; j<rows;j++){
                translate = new TranslateTransition(Duration.millis(1000));
                translate.setToX(i*MAX_CELL_SIZE+MAX_CELL_SIZE/2+10*i);
                translate.setToY(j*MAX_CELL_SIZE+MAX_CELL_SIZE/2+10*j);
                circles.add(new Circle(cell_size/2, Color.color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat())));
                translate.setNode(circles.get(circles.size()-1));
                translate.play();
                scale = new ScaleTransition(Duration.millis(1000),circles.get(circles.size()-1));
                scale.setByX((double)x_scale);
                scale.setByY((double)y_scale);
                scale.setAutoReverse(true);
                scale.setCycleCount(ScaleTransition.INDEFINITE);
                scale.play();
            }
        }
        local_canvas.getChildren().addAll(circles);
        current_rows = rows;
        current_cols = columns;
        current_cell_size = cell_size;
        current_x_scale = x_scale;
        current_y_scale = y_scale;
        local_canvas.setPrefSize(MAX_COLS * MAX_CELL_SIZE + 50, MAX_ROWS * MAX_CELL_SIZE + 50);
        return local_canvas;
    }
    
    private HBox initialize_controls(){
        HBox control_box = new HBox(10);
        VBox control_rows = new VBox(5);
        VBox control_columns = new VBox(5);
        VBox control_cell_size = new VBox(5);
        VBox control_x_scale = new VBox(5);
        VBox control_y_scale = new VBox(5);

        Label rows_label = new Label("Rows");
        Spinner<Integer> rows_spinner = new Spinner<>(1,MAX_ROWS,MAX_ROWS);
        rows_spinner.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            root.getChildren().set(0,update_circles(Integer.parseInt(newValue),current_cols,current_cell_size,current_x_scale,current_y_scale));
        });
        control_rows.getChildren().addAll(rows_label,rows_spinner);
        control_rows.setAlignment(Pos.CENTER);
        
        Label columns_label = new Label("Columns");
        Spinner<Integer> columns_spinner = new Spinner<>(1,MAX_COLS,MAX_COLS);
        columns_spinner.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            root.getChildren().set(0,update_circles(current_rows,Integer.parseInt(newValue),current_cell_size,current_x_scale,current_y_scale));
        });
        control_columns.getChildren().addAll(columns_label,columns_spinner);
        control_columns.setAlignment(Pos.CENTER);
        
        Label cell_size_label = new Label("Cell Size");
        Slider cell_size_slider = new Slider(50,MAX_CELL_SIZE,100);
        cell_size_slider.setShowTickLabels(true);
        cell_size_slider.valueChangingProperty().addListener((obs, oldValue, newValue) -> {
            root.getChildren().set(0,update_circles(current_rows,current_cols,(int)cell_size_slider.getValue(),current_x_scale,current_y_scale));
        });
        control_cell_size.getChildren().addAll(cell_size_label, cell_size_slider);
        control_cell_size.setAlignment(Pos.CENTER);
        
        Label x_scale_label = new Label("X Scale");
        Spinner<Integer> x_scale_spinner = new Spinner<>(-3,3,0);
        x_scale_spinner.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            root.getChildren().set(0,update_circles(current_rows,current_cols,current_cell_size,Integer.parseInt(newValue),current_y_scale));
        });
        control_x_scale.getChildren().addAll(x_scale_label,x_scale_spinner);
        control_x_scale.setAlignment(Pos.CENTER);
        
        Label y_scale_label = new Label("Y Scale");
        Spinner<Integer> y_scale_spinner = new Spinner<>(-3,3,0);
        y_scale_spinner.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            root.getChildren().set(0,update_circles(current_rows,current_cols,current_cell_size,current_x_scale,Integer.parseInt(newValue)));
        });
        control_y_scale.getChildren().addAll(y_scale_label,y_scale_spinner);
        control_y_scale.setAlignment(Pos.CENTER);

        control_box.getChildren().addAll(control_rows,control_columns,control_cell_size,control_x_scale,control_y_scale);
        return control_box;
    }
    
    private void update(Stage primaryStage){
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    private VBox root;
    private Pane canvas;
    private Button starter;
    private int current_rows,current_cols,current_cell_size,current_x_scale,current_y_scale;
    private HBox controls_box;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
