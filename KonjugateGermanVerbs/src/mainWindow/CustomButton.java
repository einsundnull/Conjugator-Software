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

public class CustomButton {

	@SuppressWarnings("unused")
	private int bFrame = 120;
	@SuppressWarnings("unused")
	private int bFront = 250;
	private double borderBottom = 0.5;
	private double borderLeft = 0.51;

	private double borderRight = 0.5;

	private double borderTop = 0.5;
	private  Font font = new Font("Arial", 12.5);
	private  Pane frame = new Pane();
	private  Pane front = new Pane();
	private  Pane layer = new Pane();
	private  Label lbl = new Label();
	private PaneArray shadow;

	@SuppressWarnings("unused")
	private String color;
	private String buttonID;

	private double frontHeight;
	private double frontWidth;
	@SuppressWarnings("unused")
	private int gFrame = 120;
	@SuppressWarnings("unused")
	private int gFront = 250;
	private double height = 20;

	private double isDisabled = 0.55;

	private double isFocused = 0;
	private boolean hoverReaction = true;
	private boolean isDisable;
	private boolean isMouseTransparent;
	@SuppressWarnings("unused")
	private boolean isOnMouseDragged;
	public static boolean isOnMouseHover;
	public static boolean isVisible= true;

	@SuppressWarnings("unused")
	private static boolean isOnMousePressed;
	private boolean allowHoverSound;

	private double isPressed = 0.35;
	private static double notFocused = 0.18;
	@SuppressWarnings("unused")
	private double offsetX;
	@SuppressWarnings("unused")
	private double offsetY;
	@SuppressWarnings("unused")
	private double posX;
	@SuppressWarnings("unused")
	private double posY;

	@SuppressWarnings("unused")
	private int rFrame = 120;
	@SuppressWarnings("unused")
	private int rFront = 250;

	private double width = 20;
	private int shadowLayerArraySize = 12;
	private double shadowStrength = 0.0025;
	private static double fontSize;
	private double layoutX;
	private double layoutY;

	public CustomButton(double width, double height) {

		setBackGroundFrame(100, 100, 100, 0, 0, 0, 0, false);
		setBackGroundFront(250, 250, 250, 0, 0, 0, 0, false);
		setBackGroundFrame(100, 100, 100, 40, 4, 4, 4, false);
		setBackGroundFront(250, 250, 250, 3, 3, 30, 3, true);

		this.width = width;
		this.height = height;
		frame.getChildren().addAll(front, layer, lbl);

		frame.setStyle("-fx-background-color:black");
		front.setStyle("-fx-background-color:  white  ");
		layer.setStyle("-fx-background-color:rgb(210,210,210)");
		layer.setMouseTransparent(true);
		layer.setOpacity(notFocused);
		lbl.setAlignment(Pos.CENTER);
		lbl.setFont(font);

		lbl.setStyle("-fx-background-color:transparent");
		lbl.setMouseTransparent(true);

		setPrefSize(this.width, this.height);
		setOnMouseHover();
	}

	public void allowShadow(boolean allowShadow) {

		if (allowShadow) {
			shadow = new PaneArray(shadowLayerArraySize, front, 0.5, 0, null, frontWidth - 1, frontHeight / 11.92, 0, frontHeight / 11.92);
			for (int i = 0; i < 12; i++) {
				shadow.get(i).setStyle("-fx-background-color: grey   ");
				shadow.get(i).setOpacity((double) i * i * shadowStrength);
				shadow.get(i).setMouseTransparent(true);
			}
		} else {
			if (shadow != null) {
				for (int i = 0; i < 12; i++) {
					front.getChildren().remove(shadow.get(i));
					shadow.get().clear();
					shadow = null;
				}
			}
		}
		lbl.toFront();
	}

	public void setShadowStrenght(int strength) {
		shadowStrength = strength * 0.0001;
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

	public  Pane getFrame() {
		return frame;
	}

	public  Pane getFront() {
		return front;
	}

	public Label getLabel() {
		return lbl;
	}

	public Pane getLayer() {
		return layer;
	}

	public void hoverReaction(boolean disable) {
		hoverReaction = disable;
		setOnMouseHover();
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

	public void setBackGroundFrame(int r, int g, int b, double cornerRadiusTopLeft, double cornerRadiusTopRight, double cornerRadiusBottomRight, double cornerRadiusBottomLeft,
			boolean asPercentage) {
		rFrame = r;
		gFrame = g;
		bFrame = b;
		frame.setBackground(new Background(new BackgroundFill(Color.rgb(r, g, b),
				new CornerRadii(cornerRadiusTopLeft, cornerRadiusTopRight, cornerRadiusBottomRight, cornerRadiusBottomLeft, asPercentage), new Insets(0, 0, 0, 0))));
		lbl.setBackground(new Background(new BackgroundFill(Color.rgb(r, g, b),
				new CornerRadii(cornerRadiusTopLeft, cornerRadiusTopRight, cornerRadiusBottomRight, cornerRadiusBottomLeft, asPercentage), new Insets(0, 0, 0, 0))));
	}

	public void setBackGroundFront(int r, int g, int b, double cornerRadiusTopLeft, double cornerRadiusTopRight, double cornerRadiusBottomRight, double cornerRadiusBottomLeft,
			boolean asPercentage) {
		rFront = r;
		gFront = g;
		bFront = b;
		front.setBackground(new Background(new BackgroundFill(Color.rgb(r, g, b),
				new CornerRadii(cornerRadiusTopLeft, cornerRadiusTopRight, cornerRadiusBottomRight, cornerRadiusBottomLeft, asPercentage), new Insets(0, 0, 0, 0))));
	}

	public void setDisable(boolean disable) {
		this.isDisable = disable;
		if (disable == true) {
			layer.setMouseTransparent(false);
			layer.setOpacity(isDisabled);
			lbl.setOpacity(0.5);
			this.isDisable = true;
		} else {
			layer.setMouseTransparent(true);
			layer.setOpacity(notFocused);
			lbl.setOpacity(1);
			this.isDisable = false;
		}
	}

	public void setIndex(int index) {
		frame.setId(String.valueOf(index));
	}

	public int getIndex() {
		return Integer.parseInt(frame.getId());
	}

	public void setInitalPosition(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void setLayout(double layoutX, double layoutY) {
		frame.setLayoutX(layoutX);
		frame.setLayoutY(layoutY);
	}

	public void setLayoutX(double layoutX) {
		this.layoutX = layoutX;
		frame.setLayoutX(layoutX);
	}

	public void setLayoutY(double layoutY) {
		this.layoutY = layoutY;
		frame.setLayoutY(layoutY);
	}

	public void setMouseTransparent(boolean isMouseTransparent) {
		this.isMouseTransparent = isMouseTransparent;
		frame.setMouseTransparent(isMouseTransparent);
		front.setMouseTransparent(isMouseTransparent);
		lbl.setMouseTransparent(isMouseTransparent);
		layer.setMouseTransparent(isMouseTransparent);
	}

	public  void setOnMouseClicked(Runnable run) {
		front.setOnMouseReleased(c -> {
			isOnMousePressed = false;
			if (isOnMouseHover == true) {
				run.run();
				layer.setOpacity(notFocused);
			}
		});
	}

	private void setOnMouseHover() {

		if (hoverReaction == true) {
			front.setOnMouseExited(e -> {
				layer.setOpacity(notFocused);
				isOnMouseHover = false;
			});
			front.setOnMouseEntered(e -> {
				layer.setOpacity(isFocused);
				isOnMouseHover = true;
				front.setOnMousePressed(p -> {
					isOnMousePressed = true;
					layer.setOpacity(isPressed);
				});
//				if (allowHoverSound) {
//					try {
//						URL url = getClass().getResource("/sounds/hover.mp3");
//						MediaPlayer mediaPlayer = new MediaPlayer(new Media(url.toURI().toString()));
//						mediaPlayer.setStartTime(Duration.millis(45));
//						mediaPlayer.play();
//						System.gc();
//					} catch (URISyntaxException e1) {
//						e1.printStackTrace();
//					}
//				}

			});
		} else {
			front.setOnMouseExited(e -> {
				isOnMouseHover = false;
				layer.setOpacity(notFocused);
			});
			front.setOnMouseEntered(e -> {
				isOnMouseHover = true;
				front.setOnMousePressed(p -> {
					isOnMousePressed = true;
					layer.setOpacity(isPressed);
				});
			});
		}
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

	public void setPrefSize(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
	}

	@SuppressWarnings("unused")
	private void setShadowToButton() {
		shadow = new PaneArray(12, front, 0, 0, null, frontWidth, frontHeight / 12, 0, frontHeight / 12);
		for (int i = 0; i < 12; i++) {
			shadow.get(i).setStyle("-fx-background-color: grey   ");
			shadow.get(i).setOpacity((double) i * i * 0.0025);
			shadow.get(i).setMouseTransparent(true);
		}
		lbl.toFront();
	}

	public  void setText(String text) {
		lbl.setText(text);
	}

	public  void setID(String id) {
		front.setId(id);
	}

	public String getIDByHover() {
		buttonID = "";
		front.addEventHandler(MouseEvent.MOUSE_ENTERED, h -> {
			buttonID = front.getId();
		});
		return buttonID;
	}

	public  String getID() {
		return front.getId();
	}

	public String getText() {
		return lbl.getText();
	}

	public  void setFont(String fontType, double size) {
		font = new Font(fontType, size);
		CustomButton.fontSize = size;
		Font.font(fontSize);
		lbl.setFont(font);
	}

	@SuppressWarnings("static-access")
	public void setFontSize(double fontSize) {
		this.fontSize = fontSize;
	}

	public void setVisible(boolean visible) {
		isVisible = visible;
		front.setVisible(visible);
		frame.setVisible(visible);
		layer.setVisible(visible);
	}

	public void setStyleFrame(String color) {
		frame.setStyle("-fx-background-color:" + color);
	}

	public double getLayoutX() {
		return layoutX;
	}

	public double getLayoutY() {
		return layoutY;
	}

	public boolean isAllowHoverSound() {
		return allowHoverSound;
	}
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setHoverSound(boolean allowHoverSound) {
		this.allowHoverSound = allowHoverSound;
		setOnMouseHover();
	}

	public static boolean isOnMouseHover() {
		return isOnMouseHover;
	}
}
