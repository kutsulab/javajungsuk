import java.awt.*;

public class MenuTest {
    public static void main(String[] args) {

        Frame frame = new Frame("Frame with Menu"); // 프레임 생성
        frame.setSize(300,200);

        MenuBar menuBar = new MenuBar(); // 메뉴바 생성

        //menu_File 및 그 하위 MenuItem, Menu 생성
        Menu menu_File = new Menu("File");
        MenuItem menuItem_New = new MenuItem("New");
        MenuItem menuItem_Open = new MenuItem("Open");
        Menu subMenu_Others = new Menu("Others");
        MenuItem menuItem_Exit = new MenuItem("Exit");

        // menu_File에 하위 MenuItem 및 Menu 추가
        menu_File.add(menuItem_New);
        menu_File.add(menuItem_Open);
        menu_File.add(subMenu_Others);
        menu_File.addSeparator(); // 메뉴에 분리선을 추가함.
        menu_File.add(menuItem_Exit);

        // subMenu_Others에 추가할 하위 Menu 및 MenuItem 생성 및 추가
        MenuItem menuItem_Print = new MenuItem("Print");
        MenuItem menuItem_Preview = new MenuItem("Print Preview");
        MenuItem menuItem_Setup = new MenuItem("Print Setup...");
        subMenu_Others.add(menuItem_Print);
        subMenu_Others.add(menuItem_Preview);
        subMenu_Others.add(menuItem_Setup);

        //MenuBar에 달아줄 다른 메뉴들도 추가
        Menu menu_Edit = new Menu("Edit");
        Menu menu_View = new Menu("View");
        Menu menu_Help = new Menu("Help");

        //menu_View에 CheckBoxMenuItem 생성, 추가
        CheckboxMenuItem menuItem_StatusBar = new CheckboxMenuItem("StatusBarr");
        menu_View.add(menuItem_StatusBar);

        //menuBar에 메뉴들을 추가
        menuBar.add(menu_File);
        menuBar.add(menu_Edit);
        menuBar.add(menu_View);
        menuBar.setHelpMenu(menu_Help); // 인자로 넘겨받은 메뉴를 Help menu로 지정한다.

        frame.setMenuBar(menuBar); // Frame에 지정 MenuBar를 포함한다.
        frame.setVisible(true); // 화면에 표시

    }
}
