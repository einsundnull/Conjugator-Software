package mainWindow;

import java.io.IOException;

import enums.TypeOfWindow;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CWindow extends Application {
	@FXML
	public static VBox menuVBox;
	@FXML
	private static HBox menuHBox;
	@FXML
	public static TextField germanVerbTextField;
	@FXML
	public static TextField translatedVerbTextField;
	@FXML
	public static CheckBox ckBxAkk;
	@FXML
	public static CheckBox ckBxDativ;
	@FXML
	public static CheckBox ckBxDatAkk;
	@FXML
	public static CheckBox ckBxRef;
	@FXML
	public static CheckBox ckBxHABEN;
	@FXML
	public static CheckBox ckBxSEIN;
	@FXML
	public static CheckBox ckBxDE;
	@FXML
	public static CheckBox ckBxEN;
	@FXML
	public static CheckBox ckBxRU;
	@FXML
	public static CheckBox ckBxGE;
	@FXML
	public static CheckBox ckBxAutoProp;
	@FXML
	public static CheckBox ckBxDefMan;
	@FXML
	public static CheckBox ckBxPDF;
	@FXML
	public static CheckBox ckBxEXCEL;
	@FXML
	public static CheckBox ckBxTEXT;
	@FXML
	public static CheckBox ckBxFirstGEVerb;
	@FXML
	public static CheckBox ckBxFirstTranslatedVerb;
	@FXML
	public static Button btnConjugate;
	@FXML
	public static Label lblFileName;
	@FXML
	public static Label lblWhichCase;
	@FXML
	public static Label lblRef;
	@FXML
	public static Label lblPerf;
	@FXML
	public static Label lblSaveAs;
	@FXML
	public static Label lblChooseFileName;
	@FXML
	public static Label manualLabel;
	@FXML
	public static Labeled lblHeader;
//	################################

	@FXML
	private Pane dragFieldPostition;
	@FXML
	private Pane dragFieldBottom;
	@FXML
	private Pane dragFieldRight;
	@FXML
	private Pane dragFieldTop;
	@FXML
	private Pane dragFieldLeft;


//	@FXML
//	public HBox wholeBackground;
	@SuppressWarnings("restriction")
	@FXML
	public VBox listBackground = new VBox();
	@SuppressWarnings("restriction")
	@FXML
	private VBox screenBackground = new VBox();
	@FXML
	private Pane menuBackground = new Pane();
	@FXML
	private BorderPane root = null;
	@FXML
	private Pane display;
	@FXML
	private Rectangle rect;


	@FXML
	private Pane resizeButton;
	@FXML
	private Pane exitButton;
	@FXML
	private Pane trayButton;
	@FXML
	private Pane background;
	@FXML
	private Stage stage;
	@FXML
	public Scene scene;

	private double sceneWidth;
	private double sceneHeight;
	private StageStyle stageStyle = StageStyle.UNDECORATED;
	private double stageLayoutX;
	private double stageLayoutY;

	private double initialStageLayoutX;
	private double initialStageLayoutY;

	private double screenY;
	private boolean menuBarIsOnPress;
	private double clickPointOnMenuBarX;
	private double clickPointOnMenuBarY;
	private double screenX;
	public double initialSceneWidth;
	public double initialSceneHeight;
	private double sceneX;
	private double sceneY;
	private double diffX = 0;
	private double diffY = 0;

	////////////////////////////
	@SuppressWarnings("unused")
	private TypeOfWindow type = TypeOfWindow.MAINSTAGE;
	protected Stage primaryStage;
	protected Pane layer = new Pane();
	protected Pane overLayer = new Pane();
	protected Pane dragPane = new Pane();
	protected MenuBar menuBar = new MenuBar();

	private double screenHeight;
	private double screenWidth;
	private static double borderBottom = 1;
	private static double borderLeft = 1;
	private static double borderRight = 1;
	private static double borderTop = 28;
	private static double visibleWidth;
	private static double visibleHeight;
	private double dragPaneHeight = 28;
	private double frameHeight;
	private double frameWidth;
	private static double frontHeight;
	private static double frontWidth;
	private double height = 640;
	private double offsetX;
	private double offsetY;
	private double posX;
	private double posY;
	private double prefHeight = 550;
	private double prefWidth = 800;
	private double width = 480;


	private boolean isDisabled;
	private boolean defaultCloseProcess = true;
	private boolean isFullScreen;
	private boolean isIconified;
	private boolean isMaximized;
	@SuppressWarnings("unused")
	private boolean isMouseTransparent;

	private boolean isOnMouseDragged;
	private boolean isPreferedSize;
	private boolean isDragResizeable;
	private boolean isResizeable = true;
	private FXMLLoader load;
	private static boolean setOnMouseDragged = true;

	public CWindow()  {

	}

	
	public void createWindow() {

		stage = new Stage();
		load = new FXMLLoader(this.getClass().getResource("CWindowMenu.fxml"));
//		load = new FXMLLoader(this.getClass().getResource("CWindow.fxml"));
		try {
			root = (BorderPane) load.load();
		} catch (IOException e) {
//			e.printStackTrace();
		}
		scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.initStyle(stageStyle);
		stage.setFullScreenExitHint("");
		stage.show();
		dragFieldLeft = (Pane) root.lookup("#dragFieldLeft");
		dragFieldTop = (Pane) root.lookup("#dragFieldTop");
		dragFieldRight = (Pane) root.lookup("#dragFieldRight");
		dragFieldBottom = (Pane) root.lookup("#dragFieldBottom");
		display = (Pane) root.lookup("#display");
		rect = new Rectangle();
		rect.widthProperty().bind(display.widthProperty());
		rect.heightProperty().bind(display.heightProperty());
		display.setClip(rect);
		dragFieldPostition = (Pane) root.lookup("#dragFieldPostition");
		addBtnsToMenuBar();
		setWindowOnDragResize();
		setOnKeyPressed();
		stageLayoutX = stage.getX();
		stageLayoutY = stage.getY();

//		########################
		menuVBox = (VBox) root.lookup("#menuVBox");
		menuHBox = (HBox) root.lookup("#menuHBox");
		germanVerbTextField = (TextField) root.lookup("#germanVerbTextField");
		translatedVerbTextField = (TextField) root.lookup("#translatedVerbTextField");

		ckBxAkk = (CheckBox) root.lookup("#ckBxAkk");
		ckBxDativ = (CheckBox) root.lookup("#ckBxDativ");
		ckBxDatAkk = (CheckBox) root.lookup("#ckBxDatAkk");
		ckBxRef = (CheckBox) root.lookup("#ckBxRef");
		ckBxHABEN = (CheckBox) root.lookup("#ckBxHABEN");
		ckBxSEIN = (CheckBox) root.lookup("#ckBxSEIN");
//		ckBxAutoProp = (CheckBox) root.lookup("#ckBxAutoProp");
//		ckBxDefMan = (CheckBox) root.lookup("#ckBxDefManual");
		ckBxDE = (CheckBox) root.lookup("#ckBxDE");
		ckBxEN = (CheckBox) root.lookup("#ckBxEN");
		ckBxRU = (CheckBox) root.lookup("#ckBxRU");
		ckBxGE = (CheckBox) root.lookup("#ckBxGE");
		ckBxPDF = (CheckBox) root.lookup("#ckBxPDF");
		ckBxEXCEL = (CheckBox) root.lookup("#ckBxEXCEL");
		ckBxTEXT = (CheckBox) root.lookup("#ckBxTEXT");
		ckBxFirstGEVerb = (CheckBox) root.lookup("#ckBxFirstGEVerb");
		ckBxFirstTranslatedVerb = (CheckBox) root.lookup("#ckBxFirstTranslatedVerb");
		btnConjugate = (Button) root.lookup("#btnConjugate");
		lblFileName = (Label) root.lookup("#lblFileName");
		lblHeader = (Label) root.lookup("#lblHeader");
		lblWhichCase = (Label) root.lookup("#lblWhichCase");
		lblRef = (Label) root.lookup("#lblRef");
		lblPerf = (Label) root.lookup("#lblPerf");
		lblSaveAs = (Label) root.lookup("#lblSaveAs");
		lblChooseFileName = (Label) root.lookup("#lblChooseFileName");
		manualLabel = (Label) root.lookup("#manualLabel");

	}

	private Pane setButtonOnMouseEntered(Pane btn) {
		btn.setOnMouseEntered(e -> {
			scene.setCursor(Cursor.DEFAULT);
		});
		return btn;
	}

	private void addBtnsToMenuBar() {
		resizeButton = (Pane) root.lookup("#resizeButton");
		exitButton = (Pane) root.lookup("#exitButton");
		trayButton = (Pane) root.lookup("#trayButton");
		resizeButton = setButtonOnMouseEntered(resizeButton);
		exitButton = setButtonOnMouseEntered(exitButton);
		trayButton = setButtonOnMouseEntered(trayButton);

		exitButton.setOnMouseClicked(c -> {
			Platform.exit();
		});
		resizeButton.setOnMouseClicked(c -> {
			if (!stage.isMaximized() && isResizeable) {
				setMaximizedLogic(true);
			} else if (stage.isMaximized() && isResizeable) {
				setMaximizedLogic(false);
			}

		});
		trayButton.setOnMouseClicked(c -> {
			stage.setIconified(true);
		});
	}

	private void setMaximizedLogic(boolean maximize) {
		if (!stage.isMaximized()) {
			initialStageLayoutX = stage.getX();
			initialStageLayoutY = stage.getY();
			isDragResizeable = false;
			setOnMouseDragged = false;
		}
		stage.setMaximized(maximize);
		if (!maximize) {
			stageLayoutX = initialStageLayoutX;
			stageLayoutY = initialStageLayoutY;
			stage.setX(initialStageLayoutX);
			stage.setY(initialStageLayoutY);
			isDragResizeable = true;
			setOnMouseDragged = true;
		}

		///////

		this.width = screenWidth;
		frontWidth = width - (borderLeft + borderRight);

		this.height = screenHeight;
		frontHeight = height - (borderTop + borderBottom);
	}

	private void setWindowOnDragResize() {

		dragFieldPostition.setOnMousePressed(d -> {
			if (!menuBarIsOnPress) {
				menuBarIsOnPress = true;
				clickPointOnMenuBarX = d.getSceneX();
				clickPointOnMenuBarY = d.getSceneY();
			}
		});

		dragFieldPostition.setOnMouseReleased(d -> {
			menuBarIsOnPress = false;
			stageLayoutX = stage.getX();
			stageLayoutY = stage.getY();
		});

		dragFieldPostition.setOnMouseDragged(d -> {
			if (setOnMouseDragged) {
				stage.setX(d.getScreenX() - clickPointOnMenuBarX);
				stage.setY(d.getScreenY() - clickPointOnMenuBarY);
			}
		});

		root.setOnMousePressed(d -> {
			sceneX = d.getSceneX();
			sceneY = d.getSceneY();
			screenX = d.getScreenX();
			screenY = d.getScreenY();
			initialSceneWidth = root.getWidth();
			initialSceneHeight = root.getHeight();
		});

		dragFieldLeft.setOnMouseDragged(d -> {
			resizeSide(d, 1);
		});

		dragFieldTop.setOnMouseDragged(d -> {
			resizeTop(d, 1);
		});

		dragFieldRight.setOnMouseDragged(d -> {
			resizeSide(d, -1);
		});

		dragFieldBottom.setOnMouseDragged(d -> {
			resizeTop(d, -1);
		});

		root.setOnMouseReleased(d -> {
			stageLayoutX = stage.getX();
			stageLayoutY = stage.getY();
			root.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
			display.setPrefSize(display.getPrefWidth(), root.getPrefHeight());
			sceneX = d.getSceneX();
			sceneY = d.getSceneY();
			screenX = d.getScreenX();
			screenY = d.getScreenY();
		});
	}

	public static boolean isSetOnMouseDragged() {
		boolean setOnMouseDragged = CWindow.setOnMouseDragged;
		return setOnMouseDragged;
	}

	public static void setSetOnMouseDragged(boolean setOnMouseDragged) {
		CWindow.setOnMouseDragged = setOnMouseDragged;
	}

	private void resizeSide(MouseEvent d, int leftOrRight) {
		if (isDragResizeable) {
			double moveX = d.getScreenX();
			double direction = screenX - moveX;
			double diff = direction * leftOrRight;
			sceneWidth = initialSceneWidth + diff;
			frontWidth = display.getWidth();
			diffX = (sceneX - d.getSceneX()) * -1;
			stage.setWidth(sceneWidth);
			if (leftOrRight > 0) {
				stage.setX(stageLayoutX - direction * leftOrRight);
			}
		}
	}

	private void resizeTop(MouseEvent d, int bottomOrTop) {
		if (isDragResizeable) {
			double moveY = d.getScreenY();
			double direction = screenY - moveY;
			double diff = direction * bottomOrTop;
			sceneHeight = initialSceneHeight + diff;
			frontHeight = display.getHeight();
			diffY = (sceneY - d.getSceneY()) * -1;
			stage.setHeight(sceneHeight);
			if (bottomOrTop > 0) {
				stage.setY(stageLayoutY + direction * bottomOrTop * -1);
			}
		}
	}

	public boolean isDragResizeable() {
		return isDragResizeable;
	}

	public void setDragResizeable(boolean isDragResizeable) {
		this.isDragResizeable = isDragResizeable;
	}

	public double getDiffX() {
		return diffX;
	}

	public double getDiffY() {
		return diffY;
	}

	public double getSceneWidth() {
		return sceneWidth;
	}

	public double getSceneHeight() {
		return sceneHeight;
	}

	public double getInitialSceneWidth() {
		return initialSceneWidth;
	}

	public double getInitialSceneHeight() {
		return initialSceneHeight;
	}

	public void addPaneToWindow(Pane pane) {
		display.getChildren().add(pane);
	}

	public void setMaximized(boolean maximize) {
		setMaximizedLogic(maximize);
	}

	public void setOnKeyPressed() {
		scene.setOnKeyPressed(k -> {
			if (k.getCode() == KeyCode.F11 && this.isResizeable) {
				if (!isMaximized) {
					posX = stage.getX();
					posY = stage.getY();
				}
				isFullScreen = true;
				isPreferedSize = false;
				isMaximized = false;
				setToFullScreen(true);
			}
			if (k.getCode() == KeyCode.ESCAPE && this.isResizeable) {

				if (isFullScreen) {
					isFullScreen = false;
					isMaximized = true;
					setMaximized();

				}
			}
		});
	}

	public void setToFullScreen(boolean isFullScreen) {
		this.isFullScreen = isFullScreen;

		if (isFullScreen) {
			frontHeight = screenHeight;
			frontWidth = screenWidth;
			display.setPrefSize(screenWidth, screenHeight);
			root.setPrefSize(screenWidth, screenHeight);
			layer.setPrefSize(screenWidth, screenHeight);
			stage.setFullScreen(isFullScreen);
			display.setPrefSize(stage.getWidth(), stage.getHeight());
			stage.setX(0);
			stage.setY(0);
			display.setLayoutX(0);
			display.setLayoutY(0);
		} else {
			setMaximized();
		}
	}

	public void setMinimized(boolean maximize) {

		setMaximizedLogic(maximize);
	}

	public static double addaptHeight(double height) {

		return height - 22d;
	}

	public static double addaptWidth(double width) {

		return width - 2d;
	}

	public Pane getDisplay() {
		return display;
	}

	///////////////////////////////////////////////////////////////////

	public CWindow(TypeOfWindow type, double width, double height) {

		this.type = type;
		this.width = width;
		this.height = height;
		if (width != 0) {
			prefWidth = width;
		}
		if (height != 0) {
			prefHeight = height;
		}

		stage = new Stage();
		scene = new Scene(root);

		switch (type) {
		case UNDECORATED:
			root.getChildren().clear();
			root = (BorderPane) display;
			break;
		default:
			root.getChildren().addAll(layer, display, dragPane, menuBar.newMenuBar(), overLayer);
			break;
		}

		getScreenSize();
		setPrefSize(this.width, this.height);
		setPostitions();

		menuBar.setWidth(width);
		menuBar.setHeight(height);
		setResizeable(true);
		setOnMouseDragged(true);
		setExitButtonOnAction(type);

		stage.setScene(scene);
		layer.setStyle("-fx-background-color:transparent");
		isPreferedSize = true;
		posX = stage.getX();
		posY = stage.getY();
		stage.initStyle(StageStyle.UNDECORATED);
		display.setClip(rect);
//		stage.show();
	}

	public void getScreenSize() {
		Rectangle2D rec = Screen.getPrimary().getBounds();
		screenWidth = rec.getWidth();
		screenHeight = rec.getHeight();
	}

	public double getVisibleWidth() {
		if (!isFullScreen) {
			visibleWidth = Screen.getPrimary().getBounds().getWidth() - (borderLeft + borderRight);
		} else {
			visibleWidth = Screen.getPrimary().getBounds().getWidth();
		}
		return visibleWidth;
	}

	public double getVisibleHeight() {
		if (!isFullScreen) {
			visibleHeight = Screen.getPrimary().getBounds().getHeight() - (borderTop + borderBottom);
		} else {
			visibleHeight = Screen.getPrimary().getBounds().getHeight();
		}
		return visibleHeight;
	}

	public void add(Label e) {
		display.getChildren().add(e);
	}

	public void add(Node e) {
		display.getChildren().add(e);
	}

	public void add(Pane e) {
		display.getChildren().add(e);
	}

	public void add(TextField e) {
		display.getChildren().add(e);
	}

	public void allowFullScreen(boolean allow) {

	}

	public void changeListener() {
		root.widthProperty().addListener(l -> {
			if (root.getWidth() == 0) {
				setPrefSize(height, width);
			}
		});
		root.heightProperty().addListener(l -> {
			if (root.getHeight() == 0) {
				setPrefSize(height, width);
			}
		});
	}

	public void changeListener(Runnable run) {
		root.widthProperty().addListener(l -> {
			if (root.getWidth() != 0) {
				setPrefSize(height, width);
				run.run();
			}
		});
		root.heightProperty().addListener(l -> {
			if (root.getHeight() != 0) {
				setPrefSize(height, width);
				run.run();
			}
		});
	}

	public void clear() {
		display.getChildren().clear();
		root.getChildren().clear();
		overLayer.getChildren().clear();
	}

	public void close() {
		stage.close();
	}

	public void disable(boolean disable) {

		this.isDisabled = disable;

		if (disable) {
			layer.setStyle("-fx-background-color:grey");
			layer.toFront();
			layer.setOpacity(0.5);
			overLayer.toFront();
			overLayer.setMouseTransparent(false);

		} else if (!disable) {
			layer.setStyle("-fx-background-color:transparent");
			layer.toBack();
			layer.setOpacity(0.0);
			overLayer.setMouseTransparent(true);
		}
	}

	public void disableMenuButtons(boolean disable) {
		menuBar.setDisable(disable);
	}

	private void dragProcess(Pane pane) {
		if (setOnMouseDragged) {
			if (isOnMouseDragged) {
				pane.setOnMousePressed(p -> {
					offsetX = p.getSceneX();
					offsetY = p.getSceneY();
				});
				pane.setOnMouseDragged(d -> {
					stage.setX(d.getScreenX() - offsetX);
					stage.setY(d.getScreenY() - offsetY);
				});
				pane.setOnMouseReleased(r -> {
					if (!isMaximized) {
						posX = stage.getX();
						posY = stage.getY();
					}
				});
			} else if (!isOnMouseDragged) {
				pane.setOnMousePressed(p -> {

				});
				pane.setOnMouseDragged(d -> {

				});
			}
		}
	}

	public Pane getFrame() {
		return root;
	}

	public double getFrameHeight() {
		return frameHeight;
	}

	public double getFrameWidth() {
		return frameWidth;
	}

	public Pane getFront() {
		return display;
	}

	public static double getFrontHeight() {
		return frontHeight;
	}

	public static double getFrontWidth() {
		return frontWidth;
	}

	public Pane getLayer() {
		return layer;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public Pane getOverLayer() {
		return overLayer;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public Stage getstage() {
		return stage;
	}

	public Scene getScene() {
		return stage.getScene();
	}

	public double getScreenHeight() {
		Rectangle2D rect = Screen.getPrimary().getBounds();
		screenHeight = rect.getHeight();
		return screenWidth;
	}

	public double getScreenWidth() {
		Rectangle2D rect = Screen.getPrimary().getBounds();
		screenHeight = rect.getWidth();
		return screenHeight;
	}

	public void heightChangeListener(Runnable run) {
		root.heightProperty().addListener(l -> {
			if (root.getHeight() == 0) {
				setPrefSize(height, width);
				run.run();
			}
		});
	}

	public void hide() {
		stage.hide();
	}

	public void hideCursor(boolean hide) {
		if (hide) {
			scene.setCursor(Cursor.NONE);
		} else {
			scene.setCursor(Cursor.DEFAULT);
		}
	}

	public boolean isDisabled() {
		return isDisabled;
	}

	public boolean isFullScreen() {
		return isFullScreen;
	}

	public void onlyAllowToSendToTray(boolean allow) {
		menuBar.getMaximizeButtonFrame().setMouseTransparent(allow);
	}

	public void setAlwaysOnTop(boolean alwaysOnTop) {
		stage.setAlwaysOnTop(alwaysOnTop);
	}

	public void setAlwaysOnTopFXML(boolean alwaysOnTop) {
		stage.setAlwaysOnTop(alwaysOnTop);
	}



	public void setExitButtonOnAction(Runnable run) {
		defaultCloseProcess = false;
		menuBar.setExitButtonOnAction(() -> {
			run.run();
		});

	}

	public void setExitButtonOnAction(TypeOfWindow type) {
		if (defaultCloseProcess) {
			switch (type) {
			case MAINSTAGE:
				menuBar.setExitButtonOnAction(() -> {
					Platform.exit();
				});
				break;
			case SECONDARYSTAGE:
				menuBar.setExitButtonOnAction(() -> {
					stage.close();
				});
				break;
			default:
				menuBar.setExitButtonOnAction(() -> {
					stage.close();
				});
				break;
			}
		}
	}

	@SuppressWarnings("unused")
	private void setFrameSize(double width, double height) {
		this.width = width;
		this.height = height;
		display.setPrefSize(width, height);
	}

	private void setBackToPrefSize() {
		setPrefSize(prefWidth, prefHeight);
		menuBar.setWidth(prefWidth);
		stage.setWidth(prefWidth);
		stage.setHeight(prefHeight);
		stage.setX(posX);
		stage.setY(posY);
		setPostitions();
		setOnMouseDragged(true);
		menuBar.setVisible(true);
		dragPane.setVisible(true);
	}

	public void setFullScreen(boolean isFullScreen) {
		this.isFullScreen = isFullScreen;

		if (this.isFullScreen) {
			frontHeight = screenHeight;
			frontWidth = screenWidth;
			display.setPrefSize(screenWidth, screenHeight);
//			rect.setWidth(screenWidth);
//			rect.setHeight(screenHeight);
			root.setPrefSize(screenWidth, screenHeight);
			layer.setPrefSize(screenWidth, screenHeight);
			stage.setWidth(screenWidth);
			stage.setHeight(screenHeight);
			dragPane.setPrefSize(frontWidth, 36);
			stage.setX(0);
			stage.setY(0);
			display.setLayoutX(0);
			display.setLayoutY(0);
			menuBar.setVisible(false);
			dragPane.setVisible(false);
		} else {
			setMaximized();
		}
	}

	public void setInitalPosition(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
		if (!isMaximized) {
			stage.setX(posX);
			stage.setY(posY);
		}
	}

	public void setMaximized() {

		isMaximized = true;
		setPrefSize(screenWidth, screenHeight);
		menuBar.setWidth(screenWidth);
		stage.setX(0);
		stage.setY(0);
		setPostitions();
		setOnMouseDragged(false);
		menuBar.setVisible(true);
		dragPane.setVisible(true);
	}

	public void setPrefSize(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
	}

	public void setPrefWidth(double width) {
		this.width = width;
		frontWidth = width - (borderLeft + borderRight);
		stage.setWidth(width);
//		rect.setWidth(frontWidth);
		dragPane.setPrefWidth(width);
		root.setPrefWidth(width);
		display.setPrefWidth(frontWidth);
		layer.setPrefWidth(width);
	}

	public void setPrefHeight(double height) {
		this.height = height;
		frontHeight = height - (borderTop + borderBottom);
		stage.setHeight(height);
//		rect.setHeight(frontHeight);
		dragPane.setPrefHeight(dragPaneHeight);
		root.setPrefHeight(height);
		display.setPrefHeight(frontHeight);
		layer.setPrefHeight(height);
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public void setOnCloseRequest(Runnable run) {
		defaultCloseProcess = false;
		menuBar.setExitButtonOnAction(() -> {
			run.run();
		});

	}

	public void setOnMouseDragged(boolean value) {
		isOnMouseDragged = value;
		Pane pane = null;
		if (root != display) {
			pane = dragPane;
		} else if (root == display) {
			pane = root;
		}
		dragProcess(pane);
	}

	public void setPostion(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
		stage.setX(posX);
		stage.setY(posY);
	}

	private void setPostitions() {
		double layoutX = borderLeft;
		double layoutY = borderTop;
		display.setLayoutX(layoutX);
		display.setLayoutY(layoutY);
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public void setstage(Stage stage) {
		this.stage = stage;
	}

	public void setResizeable(boolean isResizeable) {
		menuBar.allowSizeChange(isResizeable);
		this.isResizeable = isResizeable;
		if (this.isResizeable) {
			menuBar.setMinimizeButtonOnAction(() -> {
				isIconified = true;
				stage.setIconified(isIconified);
			});
			menuBar.setMaximizeButtonOnAction(() -> {
				if (!isMaximized) {
					if (isPreferedSize) {
						posX = stage.getX();
						posY = stage.getY();
					}
					setMaximized();
					isMaximized = true;
					isPreferedSize = false;
				} else if (isMaximized) {
					setBackToPrefSize();
					isFullScreen = false;
					isPreferedSize = true;
					isMaximized = false;
				}
			});
			scene.setOnKeyPressed(k -> {
				if (k.getCode() == KeyCode.F11 && this.isResizeable) {
					if (!isMaximized) {
						posX = stage.getX();
						posY = stage.getY();
					}
					isFullScreen = true;
					isPreferedSize = false;
					isMaximized = false;
					setFullScreen(true);
				}
				if (k.getCode() == KeyCode.ESCAPE && this.isResizeable) {

					if (isFullScreen) {
						isFullScreen = false;
						isMaximized = true;
						setMaximized();

					}
				}
			});
		}
	}

	public void setStyle(String style) {
		display.setStyle(style);
	}

	public void setStyleFrame(String style) {
		root.setStyle(style);
	}

	public void show() {
		stage.show();
	}

	public void toBack() {
		stage.toBack();
	}

	public void toFront() {
		stage.toFront();
	}

	public void widhtChangeListener(Runnable run) {
		root.widthProperty().addListener(l -> {
			if (root.getWidth() == 0) {
				setPrefSize(height, width);
				run.run();
			}
		});
	}

	public FXMLLoader getLoad() {
		return load;
	}

	public void setLoad(FXMLLoader load) {
		this.load = load;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}


	@Override
	public void start(Stage arg0) throws Exception {
		createWindow();
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
