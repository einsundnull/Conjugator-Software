package mainWindow;



import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class MenuBar {

	private Pane menuBar;
	private Pane layer;
	private Pane allowSizeChange;
	private CustomButton minimize;
	private CustomButton maximize;
	private CustomButton exit;

	@SuppressWarnings("unused")
	private int rFront = 240;
	@SuppressWarnings("unused")
	private int gFront = 240;
	@SuppressWarnings("unused")
	private int bFront = 240;

	@SuppressWarnings("unused")
	private static int rFrame = 110;
	@SuppressWarnings("unused")
	private static int gFrame = 110;
	@SuppressWarnings("unused")

	private static int bFrame = 110;

	@SuppressWarnings("unused")
	private double cornerRadiusTopLeft = 0;
	@SuppressWarnings("unused")
	private double cornerRadiusTopRight = 0;
	@SuppressWarnings("unused")
	private double cornerRadiusBottomLeft = 0;
	@SuppressWarnings("unused")
	private double cornerRadiusBottomRight = 0;
	@SuppressWarnings("unused")
	private boolean asPercentage = false;

	@SuppressWarnings("unused")
	private double width;
	@SuppressWarnings("unused")
	private double height;

	private double buttonHeight = 21;
	private double buttonWidth = 42;

	private Pane minimizeStroke = new Pane();

	private Pane maximizeStrokeBottom = new Pane();
	private Pane maximizeStrokeTop = new Pane();
	private Pane maximizeStrokeLeft = new Pane();
	private Pane maximizeStrokeRight = new Pane();

	private Pane maxIconI = new Pane();
	private Pane crossPane = new Pane();
	private Line lineCrossI = new Line();
	private Line lineCrossII = new Line();
	@SuppressWarnings("unused")
	private boolean isDisabled;
	@SuppressWarnings("unused")
	private boolean ExitButtonisDisabled;

	public MenuBar() {
		menuBar = new Pane();
		layer = new Pane();
		allowSizeChange = new Pane();

		layer.setPrefSize(129, 33);
		layer.setLayoutX(0);

		allowSizeChange.setPrefSize(86, 33);
		allowSizeChange.setLayoutX(0);
		allowSizeChange.setStyle("-fx-background-color: transparent");

		menuBar.setPrefSize(129, 33);

		exit = new CustomButton(buttonWidth, buttonHeight);
		minimize = new CustomButton(buttonWidth, buttonHeight);
		maximize = new CustomButton(buttonWidth, buttonHeight);

		minimize.setLayoutX(9);
		maximize.setLayoutX(52);
		exit.setLayoutX(95);

		minimize.setLayoutY(3);
		maximize.setLayoutY(3);
		exit.setLayoutY(3);

		minimize.getFrame().setStyle("-fx-background-color:  lightGrey  ");
		maximize.getFrame().setStyle("-fx-background-color:  lightGrey  ");
		exit.getFrame().setStyle("-fx-background-color:  lightGrey  ");
		
		menuBar.getChildren().addAll(maximize.newButton(), minimize.newButton(), exit.newButton(), layer,
				allowSizeChange);
		layer.toBack();
		allowSizeChange.toBack();
		setRedGreyButton();
//		exit.setShadowStrenght(33);
//		minimize.setShadowStrenght(33);
//		maximize.setShadowStrenght(33);

		exit.allowShadow(true);
		minimize.allowShadow(true);
		maximize.allowShadow(true);
		exit.setShadowToFront();
		setButtonDesign();
		requestFocus ();

	}

	private void requestFocus (){
		maximize.getFront().addEventHandler(MouseEvent.MOUSE_ENTERED, p->{
			maximize.getFront().requestFocus();
		});	
		exit.getFront().addEventHandler(MouseEvent.MOUSE_PRESSED, p->{
			exit.getFront().requestFocus();
		});
		minimize.getFront().addEventHandler(MouseEvent.MOUSE_PRESSED, p->{
			minimize.getFront().requestFocus();
		});
	}
	
	private synchronized void setRedGreyButton() {

		double duration = 0.05;

		javafx.animation.FadeTransition ft = new FadeTransition();
		javafx.animation.FadeTransition ftMax = new FadeTransition();
		javafx.animation.FadeTransition ftMin = new FadeTransition();

		Pane layerMinimized = new Pane();
		Pane layerMaximized = new Pane();
		Pane layerExit = new Pane();

		layerMaximized.setMouseTransparent(true);
		layerMaximized.setStyle("-fx-background-color:   cadetblue ");
		layerMaximized.setOpacity(0);
		layerMaximized.setPrefSize(42, 21);

		ftMax.setDuration(Duration.seconds(duration));
		ftMin.setDuration(Duration.seconds(duration));
		ft.setDuration(Duration.seconds(duration));

		layerMinimized.setMouseTransparent(true);
		layerMinimized.setStyle("-fx-background-color:   cadetblue ");
		layerMinimized.setOpacity(0);
		layerMinimized.setPrefSize(42, 21);

		layerExit.setMouseTransparent(true);
		layerExit.setStyle("-fx-background-color:  firebrick  ");
		layerExit.setOpacity(0);
		layerExit.setPrefSize(42, 21);

		ft.setNode(layerExit);
		ftMax.setNode(layerMaximized);
		ftMin.setNode(layerMinimized);

		exit.getFrame().getChildren().add(layerExit);
		maximize.getFrame().getChildren().add(layerMaximized);
		minimize.getFrame().getChildren().add(layerMinimized);

		exit.getFront().addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
			ft.stop();
			ft.setFromValue(0);
			ft.setToValue(0.4);
			ft.play();
		});
		exit.getFront().addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
			ft.stop();
			ft.setFromValue(0.4);
			ft.setToValue(0);
			ft.play();
			layerExit.setOpacity(0);
		});
		maximize.getFront().addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
			ftMax.stop();
			ftMax.setFromValue(0);
			ftMax.setToValue(0.36);
			ftMax.play();
		});
		maximize.getFront().addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
			ftMax.stop();
			ftMax.setFromValue(0.36);
			ftMax.setToValue(0);
			ftMax.play();
			layerMaximized.setOpacity(0);
		});
		minimize.getFront().addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
			ftMin.stop();
			ftMin.setFromValue(0);
			ftMin.setToValue(0.4);
			ftMin.play();
			minimize.getFront().addEventHandler(MouseEvent.MOUSE_PRESSED, h->{
				ftMin.setToValue(0);
				ftMin.play();
			});
		});
		minimize.getFront().addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
			ftMin.stop();
			ftMin.setFromValue(0.4);
			ftMin.setToValue(0);
			ftMin.play();
			layerMinimized.setOpacity(0);
		});
	}

	public void setWidth(double width) {
		this.width = width;
		menuBar.setLayoutX(width - 140);
	}

	public void setVisible(boolean value) {
		menuBar.setVisible(value);
		layer.setVisible(value);
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Pane newMenuBar() {
		return menuBar;
	}

	public void setLayoutX(double width) {
		menuBar.setLayoutX(width - 129);
	}

	public void setBackGroundFrame(CustomButtonNew btn, int r, int g, int b, double cornerRadiusTopLeft,
			double cornerRadiusTopRight, double cornerRadiusBottomRight, double cornerRadiusBottomLeft,
			boolean asPercentage) {
		rFrame = r;
		gFrame = g;
		bFrame = b;
		btn.getFront()
				.setBackground(new Background(new BackgroundFill(
						Color.rgb(r, g, b), new CornerRadii(cornerRadiusTopLeft, cornerRadiusTopRight,
								cornerRadiusBottomRight, cornerRadiusBottomLeft, asPercentage),
						new Insets(0, 0, 0, 0))));
	}

	public void setBackGroundFront(CustomButtonNew btn, int r, int g, int b, double cornerRadiusTopLeft,
			double cornerRadiusTopRight, double cornerRadiusBottomRight, double cornerRadiusBottomLeft,
			boolean asPercentage) {
		rFront = r;
		gFront = g;
		bFront = b;
		btn.getFront()
				.setBackground(new Background(new BackgroundFill(
						Color.rgb(r, g, b), new CornerRadii(cornerRadiusTopLeft, cornerRadiusTopRight,
								cornerRadiusBottomRight, cornerRadiusBottomLeft, asPercentage),
						new Insets(0, 0, 0, 0))));
	}

	public void setMaximizeButtonOnAction(Runnable run) {
		maximize.getFront().setOnMouseClicked(c -> {
			run.run();
		});
	}

	public void setMinimizeButtonOnAction(Runnable run) {
		minimize.getFront().setOnMouseClicked(c -> {
			run.run();
		});
	}

	public void setExitButtonOnAction(Runnable run) {
		exit.getFront().setOnMouseClicked(c -> {
			run.run();
		});
	}

	public void setMutualColorToFrameAndMenuBottons(String color) {
		exit.getFrame().setStyle("-fx-background-color:"+ color);
		maximize.getFrame().setStyle("-fx-background-color:"+ color);
		minimize.getFrame().setStyle("-fx-background-color:"+ color);
		
		exit.getFront().setStyle("-fx-background-color:"+ color);
		maximize.getFront().setStyle("-fx-background-color:"+ color);
		minimize.getFront().setStyle("-fx-background-color:"+ color);
	}
	
	public void setMenuBarSignsColor(String color) {
		maximizeStrokeTop.setStyle("-fx-background-color:"+ color);
		maximizeStrokeBottom.setStyle("-fx-background-color:"+ color);
		maximizeStrokeLeft.setStyle("-fx-background-color:"+ color);
		maximizeStrokeRight.setStyle("-fx-background-color:"+ color);
	}
	
	private void setButtonDesign() {

		double squareWidth = buttonHeight * 0.571;
		double squareHeight = buttonHeight * 0.571;
		double squareLayoutX = 20 - squareWidth / 2;
		double squareLayoutY = 3.5;
		@SuppressWarnings("unused")
		double lineY = buttonHeight * 0.786;

		minimizeStroke.setPrefSize(squareWidth, 0.5);
		minimizeStroke.setLayoutX(squareLayoutX);
		minimizeStroke.setLayoutY(squareHeight + squareLayoutY);
		minimizeStroke.setMouseTransparent(true);
		minimizeStroke.setStyle("-fx-background-color:  black  ");

		maximizeStrokeTop.setPrefSize(squareWidth, 3);
		maximizeStrokeBottom.setPrefSize(squareWidth, 0.5);
		maximizeStrokeLeft.setPrefSize(0.5, squareHeight);
		maximizeStrokeRight.setPrefSize(0.5, squareHeight);

		maximizeStrokeTop.setStyle("-fx-background-color:  black  ");
		maximizeStrokeBottom.setStyle("-fx-background-color:  black  ");
		maximizeStrokeLeft.setStyle("-fx-background-color:  black  ");
		maximizeStrokeRight.setStyle("-fx-background-color:  black  ");

		maximizeStrokeTop.setLayoutX(0);
		maximizeStrokeBottom.setLayoutX(0);
		maximizeStrokeLeft.setLayoutX(0);
		maximizeStrokeRight.setLayoutX(squareWidth - 0.5);

		maximizeStrokeTop.setLayoutY(0.5);
		maximizeStrokeRight.setLayoutY(0.5);
		maximizeStrokeLeft.setLayoutY(0.5);
		maximizeStrokeBottom.setLayoutY(squareHeight);

		maxIconI.setPrefSize(squareWidth, squareHeight);
		maxIconI.setLayoutX(squareLayoutX);
		maxIconI.setLayoutY(squareLayoutY);
		maxIconI.setMouseTransparent(true);

		maxIconI.setStyle("-fx-background-color:transparent");

		crossPane = new Pane();
		double crossPaneWidth = squareWidth * 0.8;
		double corrsPaneHeight = squareHeight * 0.8;

		crossPane.setLayoutX(squareLayoutX + squareWidth * 0.1);
		crossPane.setLayoutY(squareLayoutY + squareHeight * 0.12);
		crossPane.setPrefSize(crossPaneWidth, corrsPaneHeight);

		lineCrossI.setStartX(0);
		lineCrossI.setEndX(crossPaneWidth);
		lineCrossI.setStartY(0);
		lineCrossI.setEndY(corrsPaneHeight);
		lineCrossI.setMouseTransparent(true);

		lineCrossII.setStartX(0);
		lineCrossII.setEndX(crossPaneWidth);
		lineCrossII.setStartY(corrsPaneHeight);
		lineCrossII.setEndY(0);
		lineCrossII.setMouseTransparent(true);

		crossPane.getChildren().addAll(lineCrossI, lineCrossII);

		minimize.getFront().getChildren().add(minimizeStroke);
		exit.getFront().getChildren().add(crossPane);
		maxIconI.getChildren().addAll(maximizeStrokeBottom, maximizeStrokeTop, maximizeStrokeLeft, maximizeStrokeRight);
		maximize.getFront().getChildren().add(maxIconI);
	}

	public Pane getCrossPane() {
		return crossPane;
	}

	public void setDisable(boolean isDisabled) {
		this.isDisabled = isDisabled;
		if (isDisabled == true) {
			layer.toFront();
		} else if (isDisabled == false) {
			layer.toBack();
		}
	}
	
	

	public void allowSizeChange(boolean value) {
		if (value == true) {
			allowSizeChange.toBack();
		} else {
			allowSizeChange.toFront();
		}
	}

	public Pane getExitButtonFrame() {
		return exit.getFrame();
	}

	public Pane getMaximizeButtonFrame() {
		return maximize.getFrame();
	}

	public Pane getMinimzeButtonFrame() {
		return minimize.getFrame();
	}

	public CustomButton getExitButton() {
		return exit;
	}

	public CustomButton getMaximizeButton() {
		return maximize;
	}

	public CustomButton getMinimzeButton() {
		return minimize;
	}
	
	public void disableExitButton(boolean disable) {
		ExitButtonisDisabled = disable;
		if (disable == true) {
			exit.getLayer().toFront();
		} else {
			exit.getLayer().toBack();
		}
	}

	public void disableMaximizeButton(boolean disable) {
		if (disable == true) {
			maximize.getLayer().toFront();
		} else {
			maximize.getLayer().toBack();
		}
	}

	public void disableMinimizeButton(boolean disable) {
		if (disable == true) {
			minimize.getLayer().toFront();
		} else {
			minimize.getLayer().toBack();
		}
	}
}
