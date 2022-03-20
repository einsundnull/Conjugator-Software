package mainWindow;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CustomButtonNew {

	public static void main(String[] args) {

	}
	@SuppressWarnings("unused")
	private boolean allowShadow;
	@SuppressWarnings("unused")
	private int bFrame = 120;
	@SuppressWarnings("unused")
	private int bFront = 250;

	private double borderBottom = 1;

	private double borderLeft = 1;
	private double borderRight = 1;
	private double borderTop = 1;
	@SuppressWarnings("unused")
	private int btnIndex;
	// private Font font = new Font("Arial", 13);
	private Font font;
	private double fontSize = 12;
	private Pane frame;
	@SuppressWarnings("unused")
	private double frameLayoutX;
	@SuppressWarnings("unused")
	private double frameLayoutY;
	private Pane front;
	private double frontHeight;

	private double frontWidth;
	@SuppressWarnings("unused")
	private int gFrame = 120;
	@SuppressWarnings("unused")
	private int gFront = 250;
	private double height = 20;
	private boolean isDisable;
	private double isDisabled = 0.55;
	private double isHover = 0;
	private boolean isMouseTransparent;
	@SuppressWarnings("unused")
	private boolean isOnMouseDragged;
	private boolean isOnMouseHover;
	@SuppressWarnings("unused")
	private boolean isOnMousePressed;
	private double isPressed = 0.35;
	private Pane layer;
	private Label lbl;
	private double notHover = 0.18;
	@SuppressWarnings("unused")
	private double offsetX;
	@SuppressWarnings("unused")
	private double offsetY;
	@SuppressWarnings("unused")
	private double posX;
	@SuppressWarnings("unused")
	private double posY;
	@SuppressWarnings("unused")
	private Stage primaryStage;
	@SuppressWarnings("unused")
	private int rFrame = 120;
	@SuppressWarnings("unused")
	private int rFront = 250;
	private PaneArray shadow;
	private int shadowLayerArraySize = 12;

	private double width = 20;
	private double shadowStrength = 0.0025;
	@SuppressWarnings("unused")
	private String color = "grey";
	private PaneArray shadowFront;

	public CustomButtonNew(double width, double height) {

		frame = new Pane();
		front = new Pane();
		layer = new Pane();
		lbl = new Label();
		font = new Font(null, fontSize);

		
		// setBackGroundFrame(100, 100, 100, 0, 0, 0, 0, false);
		// setBackGroundFront(250, 250, 250, 0, 0, 0, 0, false);
		// setBackGroundFrame(100, 100, 100, 40, 4, 4, 4, false);
		// setBackGroundFront(250, 250, 250, 3, 3, 30, 3, true);

		this.width = width;
		this.height = height;
		frame.getChildren().addAll(front, layer, lbl);

		frame.setStyle("-fx-background-color:    grey");
		front.setStyle("-fx-background-color:  white  ");
		layer.setStyle("-fx-background-color:rgb(210,210,210)");
		layer.setMouseTransparent(true);
		layer.setOpacity(notHover);
		lbl.setAlignment(Pos.CENTER);
		lbl.setFont(font);

		setShadowToButton() ;
		lbl.setStyle("-fx-background-color:transparent");
		lbl.setMouseTransparent(true);

		setPrefSize(width, height);
		setOnMouseResponse();
	}

	public void allowShadow(boolean allowShadow) {
		if (shadow != null) {
			shadow = null;
		}
		if (allowShadow) {
			shadow = new PaneArray(shadowLayerArraySize, front, 0.5, 0, null, frontWidth-1, frontHeight / 11.92, 0,
					frontHeight / 11.92);
			for (int i = 0; i < 12; i++) {
				shadow.get(i).setStyle("-fx-background-color: grey   ");
				shadow.get(i).setOpacity((double) i * i * shadowStrength);
				shadow.get(i).setMouseTransparent(true);
			}
		}
		lbl.toFront();
	}

	public void changeListener() {
		frame.widthProperty().addListener(l -> {
			if (frame.getWidth() == 0) {
				setPrefSize(width, height);
			}
		});
		frame.heightProperty().addListener(l -> {
			if (frame.getHeight() == 0) {
				setPrefSize(width, height);
			}
		});
	}

	public double getFontSize() {
		return fontSize;
	}

	public Pane getFrame() {
		return frame;
	}

	public Pane getFront() {
		return front;
	}

	public String getID() {
		return front.getId();
	}

	public int getIndex() {
		return Integer.parseInt(frame.getId());
	}

	public Label getLabel() {
		return lbl;
	}

	public Pane getLayer() {
		return layer;
	}

	public String getText() {
		return lbl.getText();
	}

	public boolean isDisable() {
		return isDisable;
	}

	public boolean isMouseTransparent() {
		return isMouseTransparent;
	}

	public Pane newButton() {
		return frame;
	}

	public void setAlignment(Pos pos) {
		lbl.setAlignment(pos);
	}

	public void setBackGroundFrame(int r, int g, int b, double cornerRadiusTopLeft, double cornerRadiusTopRight,
			double cornerRadiusBottomRight, double cornerRadiusBottomLeft, boolean asPercentage) {
		rFrame = r;
		gFrame = g;
		bFrame = b;
		frame.setBackground(
				new Background(new BackgroundFill(
						Color.rgb(r, g, b), new CornerRadii(cornerRadiusTopLeft, cornerRadiusTopRight,
								cornerRadiusBottomRight, cornerRadiusBottomLeft, asPercentage),
						new Insets(0, 0, 0, 0))));
		lbl.setBackground(
				new Background(new BackgroundFill(
						Color.rgb(r, g, b), new CornerRadii(cornerRadiusTopLeft, cornerRadiusTopRight,
								cornerRadiusBottomRight, cornerRadiusBottomLeft, asPercentage),
						new Insets(0, 0, 0, 0))));
	}

	public void setBackGroundFront(int r, int g, int b, double cornerRadiusTopLeft, double cornerRadiusTopRight,
			double cornerRadiusBottomRight, double cornerRadiusBottomLeft, boolean asPercentage) {
		rFront = r;
		gFront = g;
		bFront = b;
		front.setBackground(
				new Background(new BackgroundFill(
						Color.rgb(r, g, b), new CornerRadii(cornerRadiusTopLeft, cornerRadiusTopRight,
								cornerRadiusBottomRight, cornerRadiusBottomLeft, asPercentage),
						new Insets(0, 0, 0, 0))));
	}

	public void setDisable(boolean disable) {
		this.isDisable = disable;
		if (disable == true) {
			layer.setMouseTransparent(false);
			layer.setOpacity(isDisabled);
			lbl.setOpacity(0.5);
		} else {
			layer.setMouseTransparent(true);
			layer.setOpacity(notHover);
			lbl.setOpacity(1);
		}
	}

	public void setFont(String fontType, double size) {
		
		lbl.setFont(new Font(fontType, size));
	}

	public void setFontSize(double fontSize) {
		this.fontSize = fontSize;
	}

	public void setIndex(int index) {
		frame.setId(String.valueOf(index));
	}

	public void setInitalPosition(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void setLayout(double layoutX, double layoutY) {
		frameLayoutX = layoutX;
		frameLayoutY = layoutY;
		frame.setLayoutX(layoutX);
		frame.setLayoutY(layoutY);
	}

	public void setLayoutX(double value) {
		frameLayoutX = value;
		frame.setLayoutX(value);
	}

	public void setLayoutY(double value) {
		frameLayoutY = value;
		frame.setLayoutY(value);
	}

	public void setMouseTransparent(boolean isMouseTransparent) {
		this.isMouseTransparent = isMouseTransparent;
		frame.setMouseTransparent(isMouseTransparent);
		front.setMouseTransparent(isMouseTransparent);
		lbl.setMouseTransparent(isMouseTransparent);
		layer.setMouseTransparent(isMouseTransparent);
	}

	public void setOnMouseClicked(Runnable run) {
		frame.addEventHandler(MouseEvent.MOUSE_RELEASED, h -> {
			isOnMousePressed = false;
			if (isOnMouseHover) {
				run.run();
				if (frame.getId() != null) {
					btnIndex = Integer.parseInt(frame.getId());
				}

				layer.setOpacity(isHover);
			} else {
				layer.setOpacity(notHover);
			}
		});
	}

	public void setOpacity(double value) {
		frame.setOpacity(value);
		front.setOpacity(value);
		layer.setOpacity(value);
		lbl.setOpacity(value);
	}

	public void setPrefHeight(double height) {
		this.height = height;
		frontHeight = height - (borderTop + borderBottom);
		double layoutY = borderTop;
		lbl.setPrefHeight(height);
		layer.setPrefHeight(height);
		front.setLayoutY(layoutY);
		front.setPrefHeight(frontHeight);
		lbl.setAlignment(Pos.CENTER);
	}

	public void setPrefSize(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
	}

	public void setPrefWidth(double width) {
		this.width = width;
		frontWidth = width - (borderLeft + borderRight);
		double layoutX = borderLeft;
		lbl.setPrefWidth(width);
		layer.setPrefWidth(width);
		front.setLayoutX(layoutX);
		front.setPrefWidth(frontWidth);
		lbl.setAlignment(Pos.CENTER);
	}

	public void setShadowStrenght (int strength){
		shadowStrength = strength*0.0001;
	}
	
	public void setShadowColor(String color) {
		this.color = color;
			for (int i = 0; i < shadowLayerArraySize; i++) {
				shadow.get(i).setStyle("-fx-background-color:" + color);
			}
	}

	public void setShadowToFront() {
		for (int i = 0; i < shadowLayerArraySize; i++) {
			shadow.get(i).toFront();
			lbl.toFront();
		}
	}

	public void setText(String text) {
		lbl.setText(text);
	}

	public void setVisible(boolean visible) {
		front.setVisible(visible);
		frame.setVisible(visible);
		layer.setVisible(visible);
	}

	private void setOnMouseResponse() {
		frame.addEventHandler(MouseEvent.MOUSE_ENTERED, h -> {
			layer.setOpacity(isHover);
			isOnMouseHover = true;
		});
		frame.addEventHandler(MouseEvent.MOUSE_EXITED, h -> {
			layer.setOpacity(notHover);
			isOnMouseHover = false;
		});
		frame.addEventHandler(MouseEvent.MOUSE_PRESSED, h -> {
			layer.setOpacity(isPressed);
			isOnMousePressed = true;
		});
		frame.addEventHandler(MouseEvent.MOUSE_RELEASED, h -> {
			isOnMousePressed = false;
			if (isOnMouseHover) {
				layer.setOpacity(isHover);
			} else {
				layer.setOpacity(notHover);
			}

		});
	}
	
//	public void hoverReaction(boolean disable) {
//		hoverReaction = disable;
//		setOnMouseHover();
//	}

//	@SuppressWarnings("unused")
//	private void setShadowToButton() {
//		shadow = new PaneArray(shadowLayerArraySize, front, 0, 0, null, frontWidth, frontHeight / 11.92, 0,
//				frontHeight / 11.92);
//		for (int i = 0; i < 12; i++) {
//			shadow.get(i).setStyle("-fx-background-color:"+color);
//			shadow.get(i).setOpacity((double) i * i * 0.0025);
//			shadow.get(i).setMouseTransparent(true);
//		}
//		lbl.toFront();
//	}
		private void setShadowToButton() {

			shadowFront = new PaneArray(20, front, 0, 0, null, frontWidth, frontHeight / 20, 0, frontHeight / 20);

			for (int i = 0; i < 20; i++) {

				shadowFront.get(i).setStyle("-fx-background-color: lightgrey   ");
				shadowFront.get(i).setOpacity((double) i * i * 0.00397);
				shadowFront.get(i).setMouseTransparent(true);
				shadowFront.get(i).toBack();
			}

//			shadowFrame = new PaneArray(20, frame, 0, 0, null, width / 20, height, width / 20, 0);

//			for (int i = 0; i < 20; i++) {
	//
//				shadowFrame.get(i).setStyle("-fx-background-color: white  ");
////				shadowFrame.get(i).setOpacity(1-(double) i * i * 0.005);
////				shadowFrame.get(i).setMouseTransparent(true);
//				shadowFrame.get(i).toBack();
//			}

			frame.setStyle("-fx-background-color:rgb(245,245,245)");

			front.setStyle("-fx-background-color:  white  ");
		}
}
