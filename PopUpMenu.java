package com.totalcross;

import totalcross.ui.Window;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;

class PopUpMenu extends Window{
    
    sys_vars vars = new sys_vars();
    Button btn_x;
    public PopUpMenu(Container a, String title_popup_menu){
        super("",NO_BORDER);
        setBorderStyle(ROUND_BORDER);
        setBackColor(0xEEEEEE);
        setRect(CENTER,CENTER,Settings.screenWidth,Settings.screenHeight);
        Container aux = new Container(){
            public void initUI(){
                add(btn_x=new Button(vars.getXIcon()),LEFT,TOP);
                add(new Label(title_popup_menu),AFTER+15,SAME+10);
                this.resize();
            }
        };
        add(aux,LEFT,TOP);
        add(a,SAME,AFTER);
        a.resize();
        this.resize();

    }
    public PopUpMenu(Container a, String title_popup_menu_a, Container b, String title_popup_menu_b){
        super("",ROUND_BORDER);
        //setBorderStyle(ROUND_BORDER);
        setBackColor(0xEEEEEE);
        setRect(CENTER,CENTER,Settings.screenWidth,Settings.screenHeight);
        Container main_container = new Container() {
            Button button_a;
            Button button_b;
            boolean control_container_a = true;
            public void initUI() {
                btn_x=new Button(vars.getXIcon());
                button_a = new Button(title_popup_menu_a);
                button_a.setBackColor(0xCCCCFF);
                button_b = new Button(title_popup_menu_b);
                add(btn_x,LEFT,TOP);
                add(button_a, LEFT, AFTER);
                add(button_b, AFTER,SAME);
                add(b, LEFT, AFTER);
                add(a, SAME, SAME);
                b.setVisible(false);
                setBorderStyle(ROUND_BORDER);
                resize();
            }
            public void onEvent(Event f) {
                if (f.type == ControlEvent.PRESSED && f.target == button_a) {
                    if(control_container_a == false){
                        button_a.setBackColor(0xCCCCFF);
                        button_b.setBackColor(0xFFFFFF);
                        control_container_a = true;
                        a.setVisible(true);
                        b.setVisible(false);
                    }
                }
                else if(f.type == ControlEvent.PRESSED && f.target == button_b){
                    if(control_container_a == true){
                        button_b.setBackColor(0xCCCCFF);
                        button_a.setBackColor(0xFFFFFF);
                        control_container_a = false;
                        a.setVisible(false);
                        b.setVisible(true);
                    }
                }
            }
        };
        add(main_container,LEFT,TOP);
        resize();
    }
    public void onEvent(Event event)
    {
    	if (event.type == ControlEvent.PRESSED && event.target == btn_x)
        	unpop(); // a WINDOW_CLOSED event will be posted to this PARENT window.
    }

}