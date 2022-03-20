package mainWindow;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class PaneArray {

	private ArrayList<Pane> arr = new ArrayList<Pane>();

	private int 	index;
	private int     size;
	private double 	setX; 
	private double 	setY;
	private double  ratioX=1;		
	private double  ratioY=1;	
	private double  distX;
	private double  distY;
	private double  PaneWidth;
	private double  PaneHeight;
	private double  width;
	private double  height;
	private ArrayList <Double> posY;
	private ArrayList <Double> posX;

	private Pane parent;
	
	public PaneArray() {}
	
	public PaneArray (int size, Pane root, double layoutX, double layoutY, String style, double width, double height, boolean addIndex, double distX, double distY, String id, String arrTxt) {                  

		this.PaneWidth   = width;
		this.PaneHeight  = height;
		this.distX   = distX;
		this.distY   = distY;
		this.size    = size;
		posX = new ArrayList<Double>();
		posY = new ArrayList<Double>();
		
		for (int i = 0; i < size; i++) {
			
		arr.add(new Pane());
		arr.get(index).setLayoutX		(layoutX	+setX*distX		);						// Sets the x-position of the TextFields. If 1 moves. If 0 doesn't move in x-direction.
		arr.get(index).setLayoutY		(layoutY	+setY*distY		);						// Sets the distance in height of the arrs.
		arr.get(index).setPrefWidth		(width					);						// Sets the width of the TextFields.
		arr.get(index).setPrefHeight	(height					);						// Sets the height of the TextFields.
		arr.get(index).setId			(id+index 				);						// Sets an ID to the TextFields.
		arr.get(index).setStyle(style);
											// The root can be null without nullpointer exception.
		
		posX.add(arr.get(i).getLayoutX());
		posY.add(arr.get(i).getLayoutY());
		
			index++;
			setX++;	
			setY++;	

		}
	}


	public PaneArray (int size, Pane root, double layoutX, double layoutY,String arrTxt , double width, double height,  double distX, double distY) {                  


		this.PaneWidth   = width;
		this.PaneHeight  = height;
		this.distX   = distX;
		this.distY   = distY;
		this.size    = size;
		posX = new ArrayList<Double>();
		posY = new ArrayList<Double>();
		
		for (int i = 0; i < size; i++) {
			
		arr.add(new Pane());
		arr.get(index).setLayoutX		(layoutX	+setX*distX		);						// Sets the x-position of the TextFields. If 1 moves. If 0 doesn't move in x-direction.
		arr.get(index).setLayoutY		(layoutY	+setY*distY		);						// Sets the distance in height of the arrs.
		arr.get(index).setPrefWidth		(width	*ratioX 		);						// Sets the width of the TextFields.
		arr.get(index).setPrefHeight	(height	*ratioY			);						// Sets the height of the TextFields.
		root.getChildren().add(arr.get(index));

		posX.add(arr.get(i).getLayoutX());
		posY.add(arr.get(i).getLayoutY());
		
		index++;
		setX++;	
		setY++;	
		}
	}
	
	public PaneArray (int size, Pane root, double layoutX, double layoutY,String arrTxt ,  double width, double height,  double distX, double distY, boolean visible) {                  


		this.PaneWidth   = width;
		this.PaneHeight  = height;
		this.distX   = distX;
		this.distY   = distY;
		this.size    = size;
		posX = new ArrayList<Double>();
		posY = new ArrayList<Double>();
		
		for (int i = 0; i < size; i++) {
			
		arr.add(new Pane());
		arr.get(index).setLayoutX		(layoutX	+setX*distX		);						// Sets the x-position of the TextFields. If 1 moves. If 0 doesn't move in x-direction.
		arr.get(index).setLayoutY		(layoutY	+setY*distY		);						// Sets the distance in height of the arrs.
		arr.get(index).setPrefWidth		(width	*ratioX 		);						// Sets the width of the TextFields.
		arr.get(index).setPrefHeight	(height	*ratioY			);						// Sets the height of the TextFields.
		arr.get(index).setVisible(visible);
		root.getChildren().add(arr.get(index));

		posX.add(arr.get(i).getLayoutX());
		posY.add(arr.get(i).getLayoutY());
		
		index++;
		setX++;	
		setY++;	
		}
	}
	
	public PaneArray (int size,  double layoutX, double layoutY, double width, double height, Stage primaryStage, double distX, double distY) {                  
		
		parent = new Pane();
		this.PaneWidth   = width;
		this.PaneHeight  = height;
		this.distX   = distX;
		this.distY   = distY;
		this.size    = size;
		posX = new ArrayList<Double>();
		posY = new ArrayList<Double>();
		
		for (int i = 0; i < size; i++) {
		arr.add(new Pane());
		arr.get(index).setLayoutX		(layoutX	+setX*distX		);						// Sets the x-position of the TextFields. If 1 moves. If 0 doesn't move in x-direction.
		arr.get(index).setLayoutY		(layoutY	+setY*distY		);						// Sets the distance in height of the arrs.
		arr.get(index).setPrefWidth		(width					);						// Sets the width of the TextFields.
		arr.get(index).setPrefHeight	(height					);						// Sets the height of the TextFields.
		parent.getChildren().add(arr.get(index));												// The root can be null without nullpointer exception.

		posX.add(arr.get(i).getLayoutX());
		posY.add(arr.get(i).getLayoutY());
		
		index++;
		setX++;	
		setY++;	
		
		}
		
	}
	
	public void bindSizeTo (Stage primaryStage) {
		
		Rectangle2D rec = Screen.getPrimary().getBounds();
		width = rec.getWidth();
		height = rec.getHeight();
		
			primaryStage.widthProperty().addListener(l->{
			
				double ratioWidth = width / primaryStage.getWidth()/2;
	
				if(ratioWidth <= 1 ) {ratioWidth = 1;}
				
				else {
					for (int i = 0 ; i < size; i++ ) {
						arr.get(i).setPrefWidth(PaneWidth/ratioWidth);
						arr.get(i).setLayoutX(posX.get(i)/ratioWidth);
						setX++;
					}
				}
			});
		
			primaryStage.heightProperty().addListener(l->{
			
				double ratioHeight = height / primaryStage.getHeight()/2;
		
				if(ratioHeight <= 1 ) {ratioHeight = 1;}
				
				else {
					for (int i = 0 ; i < size ; i++ ) {
						arr.get(i).setPrefHeight(PaneHeight/ratioHeight);
						arr.get(i).setLayoutY(posY.get(i)/ratioHeight);
						setY++;
					}
				}
			});
	}
	
	public Pane newPane(){
		return parent;
	}
	
	public void setLayoutX (double value) {
		for(int i = 0 ; i <size; i++) {
			arr.get(i).setLayoutX(value);
		}
	}
	
	public double getDistX () {
		return distX;
	}
	
	public double getDistY () {
		return distY;
	}
	
	public ArrayList <Pane> get() {
		return arr;
	}
	
	public Pane get(int index) {
		return arr.get(index);
	}
	
	public String getIndexToString () {
		return String.valueOf(this.index);
	}
	public int size() {
		return arr.size();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setStyle (Pane root,int red, int green, int blue, double topLeft, double topRight, double bottomRight, double bottomLeft, boolean asPercent, double top, double right, double bottom, double left) {
		root.setBackground(
				new Background(
				new BackgroundFill(Color.rgb(red, green, blue), 
						new CornerRadii(topLeft, topRight, bottomRight, bottomLeft, asPercent), 
						new Insets(top, right, bottom, left))));
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void setStyles (int size, Pane root,int red, int green, int blue, double topLeft, double topRight, double bottomRight, double bottomLeft, boolean asPercent, double top, double right, double bottom, double left) {
		for (int i = 0; i <= size-1; i++)
		root.setBackground(new Background(new BackgroundFill(Color.rgb(red, green, blue), new CornerRadii(topLeft, topRight, bottomRight, bottomLeft, asPercent), new Insets(top, right, bottom, left))));
	}
}
