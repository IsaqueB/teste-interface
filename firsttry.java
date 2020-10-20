package com.totalcross;

import totalcross.ui.Button;
import totalcross.ui.Check;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.SideMenuContainer;
import totalcross.ui.Slider;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.res.Resources;
import totalcross.sys.Settings;
import totalcross.ui.event.*;
import totalcross.ui.ComboBox;

public class firsttry extends MainWindow {
    sys_vars vars = new sys_vars();
    public firsttry() {
        setUIStyle(Settings.MATERIAL_UI);
    }

    @Override
    public void initUI() {
        SideMenuContainer.Item home = new SideMenuContainer.Item("Home", Resources.warning, ()-> {return new Container(){
            Container luzes_container;
            Container campainha_container;
            Container temperatura_container;
            Container seguranca_container;
            Container planta_container;
            Container music_container;
            Container temperature_study;
            Container info;
            Container entretenimento;
            public void initUI(){ // TELA 1
                luzes_container = new Container(){
                    ImageControl kitchen_light;
                    ImageControl living_room_light;
                    ImageControl porch_light;
                    ImageControl garage_light;
                    Label luzes_label = new Label("LUZES");
                    Label kitchen_label = new Label("Kitchen Lights");
                    Label living_room_label = new Label("Living Room Lights");
                    Label porch_label = new Label("Porch Lights");
                    Label garage_label = new Label("Garage Lights");
                    Check luzes_check = new Check();
                    Check kitchen_check = new Check();
                    Check living_room_check = new Check();
                    Check porch_check = new Check();
                    Check garage_check = new Check();
                    public void initUI(){
                        kitchen_light = new ImageControl(vars.getLampIcon());
                        living_room_light = new ImageControl(vars.getLampIcon());
                        porch_light = new ImageControl(vars.getLampIcon());
                        garage_light = new ImageControl(vars.getLampIcon());
                        add(luzes_label,LEFT+10,TOP+10);
                        add(kitchen_light,SAME,AFTER+10);
                        add(kitchen_label,AFTER,SAME);
                        add(living_room_light,kitchen_light.getX(),kitchen_label.getY2());
                        add(living_room_label,AFTER,SAME);
                        add(porch_light,kitchen_light.getX(),living_room_label.getY2());
                        add(porch_label,AFTER,SAME);
                        add(garage_light,kitchen_light.getX(),porch_label.getY2());
                        add(garage_label,AFTER,SAME);
                        add(luzes_check,(living_room_label.getX2()+50),luzes_label.getY());
                        add(kitchen_check,SAME,kitchen_label.getY());
                        add(living_room_check,SAME,living_room_label.getY());
                        add(porch_check,SAME,porch_label.getY());
                        add(garage_check,SAME,garage_label.getY());
                        this.setBorderStyle(BORDER_ROUNDED);
                        this.resize();
                    }
                    public void onEvent(Event event){
                        if (event.target == luzes_check && event.type == ControlEvent.PRESSED){
                            boolean aux = luzes_check.isChecked();
                            vars.setLuzesCheck(aux);
                            vars.setKitchenCheck(aux);
                            vars.setLivingRoomCheck(aux);
                            vars.setPorchCheck(aux);
                            vars.setGarageCheck(aux);
                            kitchen_check.setChecked(aux);
                            living_room_check.setChecked(aux);
                            porch_check.setChecked(aux);
                            garage_check.setChecked(aux);
                            postPressedEvent();
                        }
                        else if(event.target == kitchen_check && event.type == ControlEvent.PRESSED){
                            vars.setKitchenCheck(kitchen_check.isChecked());
                            if(kitchen_check.isChecked() || living_room_check.isChecked() || porch_check.isChecked() || garage_check.isChecked()){
                                vars.setLuzesCheck(true);
                                luzes_check.setChecked(true);
                            }
                            else{
                                vars.setLuzesCheck(false);
                                luzes_check.setChecked(false);
                            }
                            postPressedEvent();
                        }
                        else if(event.target == living_room_check && event.type == ControlEvent.PRESSED){
                            vars.setLivingRoomCheck(living_room_check.isChecked());
                            if(kitchen_check.isChecked() || living_room_check.isChecked() || porch_check.isChecked() || garage_check.isChecked()){
                                vars.setLuzesCheck(true);
                                luzes_check.setChecked(true);
                            }
                            else{
                                vars.setLuzesCheck(false);
                                luzes_check.setChecked(false);
                            }
                            postPressedEvent();
                        }
                        else if(event.target == porch_check && event.type == ControlEvent.PRESSED){
                            vars.setPorchCheck(porch_check.isChecked());
                            if(kitchen_check.isChecked() || living_room_check.isChecked() || porch_check.isChecked() || garage_check.isChecked()){
                                vars.setLuzesCheck(true);
                                luzes_check.setChecked(true);
                            }
                            else{
                                vars.setLuzesCheck(false);
                                luzes_check.setChecked(false);
                            }
                            postPressedEvent();
                        }
                        else if(event.target == garage_check && event.type == ControlEvent.PRESSED){
                            vars.setGarageCheck(garage_check.isChecked());
                            if(kitchen_check.isChecked() || living_room_check.isChecked() || porch_check.isChecked() || garage_check.isChecked()){
                                vars.setLuzesCheck(true);
                                luzes_check.setChecked(true);
                            }
                            else{
                                vars.setLuzesCheck(false);
                                luzes_check.setChecked(false);
                            }
                            postPressedEvent();
                        }
                        else if(event.type == 1508){
                            if(vars.getKitchenCheck()){
                                kitchen_check.setChecked(true);
                                kitchen_light.setBackColor(0xE3E56D);
                            }
                            else{
                                kitchen_check.setChecked(false);
                                kitchen_light.setBackColor(0xFFFFFF);
                            }
                            if(vars.getLivingRoomCheck()){
                                living_room_check.setChecked(true);
                                living_room_light.setBackColor(0xE3E56D);
                            }
                            else{
                                living_room_check.setChecked(false);
                                living_room_light.setBackColor(0xFFFFFF);
                            }
                            if(vars.getPorchCheck()){
                                porch_check.setChecked(true);
                                porch_light.setBackColor(0xE3E56D);
                            }
                            else{
                                porch_check.setChecked(false);
                                porch_light.setBackColor(0xFFFFFF);
                            }
                            if(vars.getGarageCheck()){
                                garage_check.setChecked(true);
                                garage_light.setBackColor(0xE3E56D);
                            }
                            else{
                                garage_check.setChecked(false);
                                garage_light.setBackColor(0xFFFFFF);
                            }
                            if(kitchen_check.isChecked() || living_room_check.isChecked() || porch_check.isChecked() || garage_check.isChecked()){
                                vars.setLuzesCheck(true);
                                luzes_check.setChecked(true);
                            }
                            else{
                                vars.setLuzesCheck(false);
                                luzes_check.setChecked(false);
                            }
                        }
                        
                        
                }
            };

            campainha_container = new Container(){
                Label front_door_ring_label = new Label("Front Door Ding");
                Label front_door_aux_label = new Label("Desocupado");
                Label front_door_motion_label = new Label("Front Door Motion");
                Label front_door_m_aux_label = new Label("Desligado");
                Label front_door_last_ring_label = new Label("Front Door Last Ring");
                Label front_door_last_raux_label = new Label("06:44");
                Label front_door_last_motion_label = new Label("Front Door Last Motion");
                Label front_door_last_maux_label = new Label("13:21");
                Button front_door_ring_button = new Button(vars.getHomeIcon());
                Button front_door_motion_button = new Button(vars.getWalkIcon());
                Button front_door_lring_button = new Button(vars.getRestoreIcon());
                Button front_door_lmotion_button = new Button(vars.getRestoreIcon());


                
                public void initUI(){
                    add(front_door_ring_button,LEFT,TOP);
                    add(front_door_ring_label,AFTER,SAME+9);
                    add(front_door_aux_label,AFTER+20,SAME);
                    
                    add(front_door_motion_button,LEFT,front_door_ring_button.getY2());
                    add(front_door_motion_label,AFTER,SAME+9);
                    add(front_door_m_aux_label,AFTER+20,SAME);

                    add(front_door_lring_button,LEFT,front_door_motion_button.getY2());
                    add(front_door_last_ring_label,AFTER,SAME+9);
                    add(front_door_last_raux_label,AFTER+20,SAME);

                    add(front_door_lmotion_button,LEFT,front_door_lring_button.getY2());
                    add(front_door_last_motion_label,AFTER,SAME+9);
                    add(front_door_last_maux_label,AFTER+20,SAME);

                    

                    this.setBorderStyle(BORDER_ROUNDED);
                    this.resize();
                }
                public void onEvent(Event e)
                {
                    if (e.target == front_door_ring_button && e.type == ControlEvent.PRESSED){
                        PopUpMenu tw = new PopUpMenu(vars.getFrontDoorRingContainer(),"Front Door Ring");
                        tw.popup();
                    }
                    else if (e.target == front_door_motion_button && e.type == ControlEvent.PRESSED){
                        PopUpMenu tw = new PopUpMenu(vars.getFrontDoorMotionContainer(),"Front Door Motion");
                        tw.popup();
                    }
                    else if (e.target == front_door_lring_button && e.type == ControlEvent.PRESSED){
                        PopUpMenu tw = new PopUpMenu(vars.getFrontDoorLastRingContainer(),"Front Door Last Ring");
                        tw.popup();
                    }
                    else if (e.target == front_door_lmotion_button && e.type == ControlEvent.PRESSED){
                        PopUpMenu tw = new PopUpMenu(vars.getFrontDoorLastMotionContainer(),"Front Door Last Motion");
                        tw.popup();
                    }
                }
            };
            temperatura_container = new Container(){
                Slider h_temp;
                Slider l_temp;
                Label h_temp_value_label;
                Label l_temp_value_label;
                Button options_button;
                Button check_button;
                Button hot_button;
                Button cold_button;
                Button power_button;
                String status_ac = "Automático";
                String status_pred = "Ausente";
                Label status_ac_label;
                Container temperatura_options_detalhes_container;
                Container temperatura_historico_container;
                public void initUI(){
                    options_button = new Button(vars.getMoreIcon());
                    l_temp = new Slider();
                    l_temp.setValue(40);
                    h_temp = new Slider();
                    h_temp.setValue(48);
                    l_temp_value_label = new Label(Float.toString(((float)l_temp.getValue())/2)+"ºC");
                    h_temp_value_label = new Label(Float.toString(((float)h_temp.getValue())/2)+"ºC");
                    check_button = new Button(vars.getCheckIcon());
                    hot_button = new Button(vars.getHotIcon());
                    cold_button = new Button(vars.getColdIcon());
                    power_button = new Button(vars.getPowerIcon());

                    l_temp.sliderColor = 0x55CC55;
                    h_temp.sliderColor = 0x55CC55;
                    status_ac_label = new Label(status_ac +" - "+ status_pred);

                    add(options_button,LEFT+10,TOP);
                    add(l_temp,SAME+10,AFTER+10);

                    add(h_temp,l_temp.getX(),AFTER+5);

                    add(l_temp_value_label,(h_temp.getX()+((h_temp.getWidth())/2)-45),AFTER+10);
                    add(new Label(" - "),AFTER+10,SAME);
                    add(h_temp_value_label,AFTER+10,SAME);

                    add(check_button,l_temp.getX(),AFTER+10);
                    check_button.setBackColor(0x55CC55);
                    add(hot_button, AFTER+10,SAME);
                    add(cold_button, AFTER+10,SAME);
                    add(power_button, AFTER+10,SAME);
                    add(status_ac_label,(hot_button.getX()/2),AFTER);
                    add(new Label("Andar de cima"),check_button.getX2(),AFTER);
                    l_temp.setMinimum(30);
                    l_temp.setMaximum(61);
                    h_temp.setMinimum(30);
                    h_temp.setMaximum(61);

                    this.setBorderStyle(BORDER_ROUNDED);
                    this.resize();
                }
                public void onEvent(Event e){
                    if(e.type == 300 && e.target == l_temp){
                        if(l_temp.getValue()>h_temp.getValue()){
                            l_temp.setValue(h_temp.getValue());
                        }
                        l_temp_value_label.setText(Float.toString((((float)l_temp.getValue())/2))+"ºC");
                    }
                    else if(e.type == 300 && e.target == h_temp){
                        if(h_temp.getValue()<l_temp.getValue()){
                            h_temp.setValue(l_temp.getValue());
                        }
                        h_temp_value_label.setText(Float.toString(((float)h_temp.getValue())/2)+"ºC");
                    }
                    else if(e.type == ControlEvent.PRESSED && e.target == check_button){
                        if(status_atual() != e.target){
                            status_atual().setBackColor(0xFFFFFF);
                            status_ac = "Automático";
                            ((Button)e.target).setBackColor(0x55CC55);
                            l_temp.sliderColor = 0x55CC55;
                            h_temp.sliderColor = 0x55CC55;
                            status_ac_label.setText(status_ac+"-"+status_pred);
                        }
                    }
                    else if(e.type == ControlEvent.PRESSED && e.target == hot_button){
                        if(status_atual() != e.target){
                            status_atual().setBackColor(0xFFFFFF);
                            status_ac = "Quente";
                            ((Button)e.target).setBackColor(0xCC5555);
                            l_temp.sliderColor = 0xCC5555;
                            h_temp.sliderColor = 0xCC5555;
                            status_ac_label.setText(status_ac+"-"+status_pred);
                        }
                    }
                    else if(e.type == ControlEvent.PRESSED && e.target == cold_button){
                        if(status_atual() != e.target){
                            status_atual().setBackColor(0xFFFFFF);
                            status_ac = "Frio";
                            ((Button)e.target).setBackColor(0x5555CC);
                            l_temp.sliderColor = 0x5555CC;
                            h_temp.sliderColor = 0x5555CC;
                            status_ac_label.setText(status_ac+"-"+status_pred);
                        }
                    }
                    else if(e.type == ControlEvent.PRESSED && e.target == power_button){
                        if(status_atual() != e.target){
                            status_atual().setBackColor(0xFFFFFF);
                            status_ac = "Desligado";
                            ((Button)e.target).setBackColor(0xAAAAAA);
                            l_temp.sliderColor = 0xAAAAAA;
                            h_temp.sliderColor = 0xAAAAAA;
                            status_ac_label.setText(status_ac+"-"+status_pred);
                        }
                    }
                    else if(e.type == ControlEvent.PRESSED && e.target == options_button){
                        temperatura_options_detalhes_container = new Container(){
                            Label aux1;
                            Label aux2;
                            Label l_temp_label;
                            Label h_temp_label;
                            Button up_l_button;
                            Button down_l_button;
                            Button up_h_button;
                            Button down_h_button;
                            ComboBox operation_combobox;
                            ComboBox predefinir_combobox;
                            ComboBox vent_mode_combobox;
                            Object prev_operation;
                            Object prev_predefinir;
                            public void initUI(){
                                setBackColor(0xFFFFFF);
                                aux1 = new Label("Andar de cima");
                                aux2 = new Label(status_ac_label.getText());
                                l_temp_label = new Label(Float.toString(((float)l_temp.getValue())/2)+"ºC");
                                up_l_button = new Button(vars.getUpIcon());
                                down_l_button = new Button(vars.getDownIcon());
                                h_temp_label = new Label(Float.toString(((float)h_temp.getValue())/2)+"ºC");
                                up_h_button = new Button(vars.getUpIcon());
                                down_h_button = new Button(vars.getDownIcon());
                                operation_combobox = new ComboBox(new String[]{"Automático","Quente","Frio","Desligado"});
                                operation_combobox.setSelectedIndex(0);
                                prev_operation = operation_combobox.getSelectedItem();
                                predefinir_combobox = new ComboBox(new String[]{"Home","Ausente","Eco","Suspender"});
                                predefinir_combobox.setSelectedIndex(1);
                                prev_predefinir = predefinir_combobox.getSelectedItem();
                                vent_mode_combobox = new ComboBox(new String[]{"Automático","Ligado"});
                                vent_mode_combobox.setSelectedIndex(0);
                                
                                add(aux1,LEFT+10,TOP+10);
                                add(new Label("1 hora atrás"),SAME,AFTER);
                                add(aux2,aux1.getX2()+50,TOP+10);
                                add(new Label(l_temp_value_label.getText()+"-"+h_temp_value_label.getText()),AFTER,SAME);
                                add(new Label("Atualmente: 22ºC"),SAME,AFTER);
                                add(new Label("Temperatura desejada"),LEFT+10,AFTER);
                                
                                add(l_temp_label,LEFT+10,(AFTER+30));
                                add(up_l_button,AFTER,(SAME-30));
                                add(down_l_button,SAME,AFTER);
                                add(h_temp_label,AFTER+10,(l_temp_label.getY()));
                                add(up_h_button,AFTER,(SAME-30));
                                add(down_h_button,SAME,AFTER);
                                add(new Label("Operação"),LEFT+10,AFTER);
                                add(operation_combobox,SAME,AFTER);
                                add(new Label("Predefinir"),SAME,AFTER);
                                add(predefinir_combobox,SAME,AFTER);
                                add(new Label("Modo ventilação"),SAME,AFTER);
                                add(vent_mode_combobox,SAME,AFTER);
        
                                resize();
        
                            }
                            public void onEvent(Event event){
                                if(event.target == up_l_button && event.type == ControlEvent.PRESSED){
                                    if(l_temp.getValue()<60 && l_temp.getValue()<h_temp.getValue()){
                                        l_temp.setValue(l_temp.getValue()+1);
                                        l_temp_label.setText(Float.toString(((float)l_temp.getValue())/2)+"ºC");
                                        l_temp_value_label.setText(l_temp_label.getText());
                                    }
                                }
                                else if(event.target == down_l_button && event.type == ControlEvent.PRESSED){
                                    if(l_temp.getValue()>30){
                                        l_temp.setValue(l_temp.getValue()-1);
                                        l_temp_label.setText(Float.toString(((float)l_temp.getValue())/2)+"ºC");
                                        l_temp_value_label.setText(l_temp_label.getText());
                                    }
                                }
                                else if(event.target == up_h_button && event.type == ControlEvent.PRESSED){
                                    if(h_temp.getValue()<60){
                                        h_temp.setValue(h_temp.getValue()+1);
                                        h_temp_label.setText(Float.toString(((float)h_temp.getValue())/2)+"ºC");
                                        h_temp_value_label.setText(h_temp_label.getText());
                                    }
                                }
                                else if(event.target == down_h_button && event.type == ControlEvent.PRESSED){
                                    if(h_temp.getValue()>30 && l_temp.getValue()<h_temp.getValue()){
                                        h_temp.setValue(h_temp.getValue()-1);
                                        h_temp_label.setText(Float.toString(((float)h_temp.getValue())/2)+"ºC");
                                        h_temp_value_label.setText(h_temp_label.getText());
                                    }
                                }
                                else if(event.target == operation_combobox){
                                    if(prev_operation != operation_combobox.getSelectedItem()){
                                        status_ac = ((String)operation_combobox.getSelectedItem());
                                        status_ac_label.setText(status_ac +" - "+ status_pred);
                                        aux2.setText(status_ac_label.getText());
                                    }
                                }
                                else if(event.target == predefinir_combobox){
                                    if(prev_predefinir != predefinir_combobox.getSelectedItem()){
                                        status_pred = ((String)predefinir_combobox.getSelectedItem());
                                        status_ac_label.setText(status_ac +" - "+ status_pred);
                                        aux2.setText(status_ac_label.getText());
                                    }
                                }
                            }
                        };
                        temperatura_historico_container =  new Container(){
                            public void initUI(){
                                try{
                                    add(new ImageControl(new Image("img/historico_temp.png")),LEFT+30,TOP+30);
                                }
                                catch(Exception e){}
                                resize();
                            }
                        };
                        PopUpMenu tw = new PopUpMenu(temperatura_options_detalhes_container,"DETALHES",temperatura_historico_container,"HISTORICO");
                        tw.popup();
                    }
                }
                private Button status_atual(){
                    switch (status_ac) {
                        case "Automático":
                            return check_button;
                        case "Quente":
                            return hot_button;
                        case "Frio":
                            return cold_button;
                        case "Desligado":
                            return power_button;
                        default:
                            return new Button("a");
                    }
                }
            };
            seguranca_container = new Container(){
                Container alarm_container;
                Button security;
                Button alarmar_em_casa;
                Button alarmar_ausente;
                Button desarmar;
                Label status_label;
                String status = "Desarmado";
                public void initUI(){
                    security = new Button(vars.getSecurityIcon());
                    security.setBackColor(0xAAFFAA);
                    status_label = new Label("Armado");
                    status_label.setBackColor(0xFFAAAA);
                    status_label.setVisible(false);
                    alarm_container = new Container(){
                        public void initUI(){
                            alarmar_em_casa = new Button("Alarmar em Casa");
                            alarmar_ausente = new Button("Alarmar Ausente");
                            desarmar = new Button("Desarmar");
                            add(alarmar_em_casa,LEFT,TOP+10);
                            add(alarmar_ausente,SAME,AFTER);
                            add(desarmar,alarmar_em_casa.getX()+20,SAME);
                            if(status == "Desarmado"){
                                desarmar.setVisible(false);
                            }
                            else{
                                alarmar_em_casa.setVisible(false);
                                alarmar_ausente.setVisible(false);
                            }
                            resize();
                        }
                        public void onEvent(Event e){
                            if(e.target == alarmar_em_casa && e.type == ControlEvent.PRESSED){
                                security.setBackColor(0xFFAAAA);
                                status_label.setVisible(true);
                                alarmar_em_casa.setVisible(false);
                                alarmar_ausente.setVisible(false);
                                desarmar.setVisible(true);
                                status = "Armado casa";
                            }
                            if(e.target == alarmar_ausente && e.type == ControlEvent.PRESSED){
                                security.setBackColor(0xFFAAAA);
                                status_label.setVisible(true);
                                alarmar_em_casa.setVisible(false);
                                alarmar_ausente.setVisible(false);
                                desarmar.setVisible(true);
                                status = "Armado ausente";
                            }
                            else if(e.target == desarmar && e.type == ControlEvent.PRESSED){
                                security.setBackColor(0xAAFFAA);
                                status_label.setVisible(false);
                                alarmar_em_casa.setVisible(true);
                                alarmar_ausente.setVisible(true);
                                desarmar.setVisible(false);
                                status = "Desarmado";
                            }
                        }
                    };
                    add(new Label("Security"),LEFT+40,TOP+10);
                    add(security,AFTER+50,SAME);
                    add(status_label,SAME,AFTER);
                    add(alarm_container,LEFT+40,AFTER+10);
                    setBorderStyle(BORDER_ROUNDED);
                    resize();
                }
                public void onEvent(Event e){
                    if(e.target == security && e.type == ControlEvent.PRESSED){

                        Container detalhes = new Container(){
                            public void initUI(){
                                Label aux;
                                add(aux = new Label("Adobe Alarm"),LEFT+10,TOP+10);
                                add(new Label("3 horas atrás"), SAME,AFTER);
                                Container aux_alarm_container = new Container(){
                                    Button alarmar_em_casa;
                                    Button alarmar_ausente;
                                    Button desarmar;
                                    public void initUI(){
                                        setBackColor(0xFFFFFF);
                                        alarmar_em_casa = new Button("Alarmar em Casa");
                                        alarmar_ausente = new Button("Alarmar Ausente");
                                        desarmar = new Button("Desarmar");
                                        add(alarmar_em_casa,LEFT,TOP+10);
                                        add(alarmar_ausente,SAME,AFTER);
                                        add(desarmar,alarmar_em_casa.getX()+20,SAME);
                                        if(status == "Desarmado"){
                                            desarmar.setVisible(false);
                                        }
                                        else{
                                            alarmar_em_casa.setVisible(false);
                                            alarmar_ausente.setVisible(false);
                                        }
                                        resize();
                                    }
                                    public void onEvent(Event e){
                                        if(e.target == alarmar_em_casa && e.type == ControlEvent.PRESSED){
                                            security.setBackColor(0xFFAAAA);
                                            status_label.setVisible(true);
                                            alarmar_em_casa.setVisible(false);
                                            alarmar_ausente.setVisible(false);
                                            desarmar.setVisible(true);
                                            status = "Armado casa";
                                        }
                                        if(e.target == alarmar_ausente && e.type == ControlEvent.PRESSED){
                                            security.setBackColor(0xFFAAAA);
                                            status_label.setVisible(true);
                                            alarmar_em_casa.setVisible(false);
                                            alarmar_ausente.setVisible(false);
                                            desarmar.setVisible(true);
                                            status = "Armado ausente";
                                        }
                                        else if(e.target == desarmar && e.type == ControlEvent.PRESSED){
                                            security.setBackColor(0xAAFFAA);
                                            status_label.setVisible(false);
                                            alarmar_em_casa.setVisible(true);
                                            alarmar_ausente.setVisible(true);
                                            desarmar.setVisible(false);
                                            status = "Desarmado";
                                        }
                                    }
                                };
                                add(aux_alarm_container,LEFT+10,AFTER+5);
                                add(new Label(status),aux.getX2(),TOP+10);
                                resize();
                            }
                        };
                        Container historico_security =  new Container(){
                            public void initUI(){
                                try{
                                    add(new ImageControl(new Image("img/historico_security.png")),LEFT+30,TOP+30);
                                }
                                catch(Exception e){}
                                resize();
                            }
                        };


                        PopUpMenu tw = new PopUpMenu(detalhes,"DETALHES",historico_security,"HISTORICO");
                        tw.popup();
                    }
                    else if(e.type == 303){
                        if(status == "Desarmado"){
                            desarmar.setVisible(false);
                            alarmar_em_casa.setVisible(true);
                            alarmar_ausente.setVisible(true);
                        }
                        else{
                            desarmar.setVisible(true);
                            alarmar_em_casa.setVisible(false);
                            alarmar_ausente.setVisible(false);
                        }
                    }
                }

            };


        planta_container = new Container(){
            Image planta_img;
            ImageControl planta;
            Button camera_nw;
            Button camera_sw;
            Button camera_se;
            Button camera_ne;
            Button kitchen_lights;
            Button living_room_lights;
            Button porch_lights;
            Button garage_lights;
            Button back_door;
            Button front_door;
            Button front_door_motion;
            Button living_room_occupancy;
            Button guest_room_occupancy;
            Button living_room_temp;
            Button study_room_temp;
            Button garage_door;
                float prop_x;
                float prop_y;
                boolean status_garage = false; //TRUE = ABRINDO FALSE = FECHANDO
                public void initUI(){
                    try{
                        planta_img = new Image("img/planta.png");
                        planta_img = planta_img.scaledBy(1, 0.7);
                        planta = new ImageControl(planta_img); // 490x573
                        add(planta,LEFT,TOP);
                        prop_x = planta.getWidth()/(float)490;
                        prop_y = planta.getHeight()/(float)573;
                    }
                    catch(Exception e){}
                    camera_nw = new Button(vars.getCameraIcon());
                    camera_sw = new Button(vars.getCameraIcon());
                    camera_se = new Button(vars.getCameraIcon());
                    camera_ne = new Button(vars.getCameraIcon());
                    kitchen_lights = new Button(vars.getLampIcon());
                    living_room_lights = new Button(vars.getLampIcon());
                    porch_lights = new Button(vars.getLampIcon());
                    garage_lights = new Button(vars.getLampIcon());
                    back_door = new Button(vars.getDoorIcon());
                    front_door = new Button(vars.getDoorIcon());
                    front_door_motion = new Button(vars.getWalkIcon());
                    living_room_occupancy = new Button(vars.getWalkIcon());
                    guest_room_occupancy = new Button (vars.getWalkIcon());
                    living_room_temp = new Button(vars.getColdIcon());
                    study_room_temp = new Button(vars.getColdIcon());
                    garage_door = new Button(vars.getHomeIcon());
                    add(camera_nw,(int)(planta.getX()+(prop_x*20)),(int)(planta.getY()+(prop_y*60)));
                    add(camera_sw,SAME,(int)(planta.getY2()-(prop_y*60)));
                    add(camera_se,(int)(planta.getX2()-(prop_x*70)),(int)(SAME-(prop_y*40)));
                    add(camera_ne,SAME,camera_nw.getY());
                    add(kitchen_lights,(int)(planta.getX()+prop_x*35),(int)(planta.getY()+prop_y*230));
                    add(living_room_lights,(int)(planta.getWidth()/2-(15*prop_x)),(int)(SAME-(10*prop_y)-kitchen_lights.getHeight()));
                    add(porch_lights,(int)(camera_sw.getX2()+(30*prop_x)),camera_sw.getY());
                    add(garage_lights,(int)(camera_se.getX()-(prop_x*60)),(int)(planta.getHeight()/2+(prop_y*40)));
                    add(back_door,(int)(camera_nw.getX2()-prop_x*10),camera_nw.getY2()-back_door.getHeight());
                    add(front_door,(int)(porch_lights.getX2()+prop_x*4),porch_lights.getY()-back_door.getHeight());
                    add(front_door_motion,front_door.getX(),porch_lights.getY());
                    add(living_room_occupancy,living_room_lights.getX(),living_room_lights.getY()-living_room_lights.getHeight());
                    add(guest_room_occupancy,(int)(camera_ne.getX2()-prop_x*65),camera_ne.getY2());
                    add(living_room_temp,living_room_lights.getX(),living_room_lights.getY2());
                    add(study_room_temp,living_room_temp.getX(),(int)(living_room_temp.getY()+prop_y*200));
                    add(garage_door,garage_lights.getX(),(int)(garage_lights.getY2()+prop_y*50));
                    resize();
                }
            public void onEvent(Event e){
                if(e.target == camera_nw && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            try{
                                add(new ImageControl(new Image("img/camera_nw.png")),LEFT,TOP);
                            }catch(Exception e){}
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Patio");
                    tw.popup();
                }
                else if(e.target == camera_sw && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            try{
                                add(new ImageControl(new Image("img/camera_sw.png")),LEFT,TOP);
                            }catch(Exception e){}
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Porch");
                    tw.popup();
                }
                else if(e.target == camera_se && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            try{
                                add(new ImageControl(new Image("img/camera_se.png")),LEFT,TOP);
                            }catch(Exception e){}
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Driveway");
                    tw.popup();
                }
                else if(e.target == camera_ne && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            try{
                                add(new ImageControl(new Image("img/camera_ne.png")),LEFT,TOP);
                            }catch(Exception e){}
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Backyard");
                    tw.popup();
                }
                else if(e.target == kitchen_lights && e.type == ControlEvent.PRESSED){
                    boolean aux = vars.getKitchenCheck();
                    vars.setKitchenCheck(!aux);
                    if(!aux){
                        kitchen_lights.setBackColor(0xE3E56D);
                    }
                    else{
                        kitchen_lights.setBackColor(0xFFFFFF);
                    }
                    kitchen_lights.press(true);
                    postPressedEvent();
                    
                }
                else if(e.target == living_room_lights && e.type == ControlEvent.PRESSED){
                    boolean aux = vars.getLivingRoomCheck();
                    vars.setLivingRoomCheck(!aux);
                    living_room_lights.setBackColor(0xE3E56D);
                    if(!aux){
                        living_room_lights.setBackColor(0xE3E56D);
                    }
                    else{
                        living_room_lights.setBackColor(0xFFFFFF);
                    }
                    living_room_lights.press(true);
                    postPressedEvent();

                }
                else if(e.target == porch_lights && e.type == ControlEvent.PRESSED){
                    boolean aux = vars.getPorchCheck();
                    vars.setPorchCheck(!aux);
                    if(!aux){
                        porch_lights.setBackColor(0xE3E56D);
                    }
                    else{
                        porch_lights.setBackColor(0xFFFFFF);
                    }
                    porch_lights.press(true);
                    postPressedEvent();
                    

                }
                else if(e.target == garage_lights && e.type == ControlEvent.PRESSED){
                    boolean aux = vars.getGarageCheck();
                    vars.setGarageCheck(!aux);
                    garage_lights.setBackColor(0xE3E56D);
                    if(!aux){
                        garage_lights.setBackColor(0xE3E56D);
                    }
                    else{
                        garage_lights.setBackColor(0xFFFFFF);
                    }
                    garage_lights.press(true);
                    postPressedEvent();
                }
                else if(e.target == back_door && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            add(new ImageControl(vars.getDoorIcon()),LEFT+10,TOP+10);
                            add(new Label("Back Door"),AFTER,SAME);
                            add(new Label("3 horas atrás"),SAME,AFTER);
                            add(new Label("Fechado"),AFTER+50,TOP+10);
                            add(new Label(""),SAME,AFTER);
                            try{
                                add(new ImageControl(new Image("img/back_door.png")),LEFT+10,AFTER+10);
                            }catch(Exception e){}
                            add(new Label("device id"),LEFT+10,AFTER+10);
                            add(new Label("RF:005c7110"),AFTER+50,SAME);
                            add(new Label("battery low"),LEFT+10,AFTER);
                            add(new Label("false"),AFTER+50,SAME);
                            add(new Label("no response"),LEFT+10,AFTER);
                            add(new Label("false"),AFTER+50,SAME);
                            add(new Label("device type"),LEFT+10,AFTER);
                            add(new Label("Door contact"),AFTER+50,SAME);
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Back Door");
                    tw.popup();
                }
                else if(e.target == front_door && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            add(new ImageControl(vars.getDoorIcon()),LEFT+10,TOP+10);
                            add(new Label("Front Door"),AFTER,SAME);
                            add(new Label("2 horas atrás"),SAME,AFTER);
                            add(new Label("Fechado"),AFTER+50,TOP+10);
                            add(new Label(""),SAME,AFTER);
                            try{
                                add(new ImageControl(new Image("img/front_door.png")),LEFT+10,AFTER+10);
                            }catch(Exception e){}
                            add(new Label("device id"),LEFT+10,AFTER+10);
                            add(new Label("RF:005e8810"),AFTER+50,SAME);
                            add(new Label("battery low"),LEFT+10,AFTER);
                            add(new Label("false"),AFTER+50,SAME);
                            add(new Label("no response"),LEFT+10,AFTER);
                            add(new Label("false"),AFTER+50,SAME);
                            add(new Label("device type"),LEFT+10,AFTER);
                            add(new Label("Door contact"),AFTER+50,SAME);
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Front Door");
                    tw.popup();
                }
                else if(e.target == front_door_motion && e.type == ControlEvent.PRESSED){
                    PopUpMenu tw = new PopUpMenu(vars.getFrontDoorMotionContainer(),"Front Door");
                    tw.popup();
                }
                else if(e.target == living_room_occupancy && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            add(new ImageControl(vars.getWalkIcon()),LEFT+10,TOP+10);
                            add(new Label("Living Room Occupancy"),AFTER,SAME);
                            add(new Label("39 minutos atrás"),SAME,AFTER);
                            add(new Label("Desligado"),AFTER+100,TOP+10);
                            add(new Label(""),SAME,AFTER);
                            try{
                                add(new ImageControl(new Image("img/front_door_motion_img.png")),LEFT+10,AFTER+10);
                            }catch(Exception e){}
                            add(new Label("No motion since"),LEFT+10,AFTER+10);
                            add(new Label("120"),AFTER+50,SAME);
                            add(new Label("battery level"),LEFT+10,AFTER);
                            add(new Label("43"),AFTER+50,SAME);
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Living Room Occupancy");
                    tw.popup();
                }
                else if(e.target == guest_room_occupancy && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            add(new ImageControl(vars.getWalkIcon()),LEFT+10,TOP+10);
                            add(new Label("Guest Room Occupancy"),AFTER,SAME);
                            add(new Label("1 hora atrás"),SAME,AFTER);
                            add(new Label("Desligado"),AFTER+100,TOP+10);
                            add(new Label(""),SAME,AFTER);
                            try{
                                add(new ImageControl(new Image("img/front_door_motion_img.png")),LEFT+10,AFTER+10);
                            }catch(Exception e){}
                            add(new Label("No motion since"),LEFT+10,AFTER+10);
                            add(new Label("0"),AFTER+50,SAME);
                            add(new Label("battery level"),LEFT+10,AFTER);
                            add(new Label("49"),AFTER+50,SAME);
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Guest Room Occupancy");
                    tw.popup();
                }
                else if(e.target == living_room_temp && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            add(new ImageControl(vars.getEyeIcon()),LEFT+10,TOP+10);
                            add(new Label("Living Room Temperature"),AFTER,SAME);
                            add(new Label("1 hora atrás"),SAME,AFTER);
                            add(new Label("21"),AFTER+100,TOP+10);
                            add(new Label(""),SAME,AFTER);
                            try{
                                add(new ImageControl(new Image("img/living_room_temp.png")),LEFT+10,AFTER+10);
                            }catch(Exception e){}
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Living Room Temperature");
                    tw.popup();
                }
                else if(e.target == study_room_temp && e.type == ControlEvent.PRESSED){
                    Container aux = new Container(){
                        public void initUI(){
                            add(new ImageControl(vars.getEyeIcon()),LEFT+10,TOP+10);
                            add(new Label("Study Room Temperature"),AFTER,SAME);
                            add(new Label("2 hora atrás"),SAME,AFTER);
                            add(new Label("23"),AFTER+100,TOP+10);
                            add(new Label(""),SAME,AFTER);
                            try{
                                add(new ImageControl(new Image("img/study_room_temp.png")),LEFT+10,AFTER+10);
                            }catch(Exception e){}
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(aux,"Study Room Temperature");
                    tw.popup();
                }
                else if(e.target == garage_door && e.type == ControlEvent.PRESSED){ //NÃO ACHEI HOLD
                    Container detalhes_garage_door = new Container(){
                        ImageControl garage_icon;
                        Button up;
                        Button stop;
                        Button down;
                        public void initUI(){
                            garage_icon = new ImageControl(vars.getHomeIcon());
                            up = new Button(vars.getUpIcon());
                            stop = new Button(vars.getStopIcon());
                            down = new Button(vars.getDownIcon());
                            add(garage_icon,LEFT+10,TOP+10);
                            add(new Label("Garage Door"),AFTER,SAME);
                            add(new Label("1 hora atrás"),SAME,AFTER);
                            add(up,AFTER+20,TOP+10);
                            add(stop,AFTER,SAME);
                            add(down,AFTER,SAME);
                            resize();
                        }
                        public void onEvent(Event e){
                            if(e.target == up && e.type == ControlEvent.PRESSED){
                                if(status_garage){}
                                else{
                                    status_garage = true;
                                    garage_door.setBackColor(0xFF0000);
                                    garage_door.press(true);
                                }
                            }
                            else if(e.target == down && e.type == ControlEvent.PRESSED){
                                if(status_garage){
                                    status_garage = false;
                                    garage_door.setBackColor(0x00FF00);
                                    garage_door.press(true);
                                }
                            }
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(detalhes_garage_door,"Garage Door");
                    tw.popup();
                }
                else if(e.type == 1508){
                    if(vars.getKitchenCheck()){
                        kitchen_lights.setBackColor(0xE3E56D);
                    }
                    else{
                        kitchen_lights.setBackColor(0xFFFFFF);
                    }
                    if(vars.getLivingRoomCheck()){
                        living_room_lights.setBackColor(0xE3E56D);
                    }
                    else{
                        living_room_lights.setBackColor(0xFFFFFF);
                    }
                    if(vars.getPorchCheck()){
                        porch_lights.setBackColor(0xE3E56D);
                    }
                    else{
                        porch_lights.setBackColor(0xFFFFFF);
                    }
                    if(vars.getGarageCheck()){
                        garage_lights.setBackColor(0xE3E56D);
                    }
                    else{
                        garage_lights.setBackColor(0xFFFFFF);
                    }
                }
            }
        };

        music_container = new Container(){
            Container controls;
            boolean status = true; //0 = PAUSADO; 1 = TOCANDO
            Image img;
            ImageControl imgctrl;
            Button options;
            float prop_y;
            public void initUI(){
                controls = new Container(){
                    ImageControl cast;
                    Button prev;
                    Button play;
                    Button next;
                    public void initUI(){
                        setBackColor(0xFBC204);
                        cast = new ImageControl(vars.getCastIcon());
                        prev = new Button(vars.getPrevIcon());
                        play = new Button(vars.getPlayIcon());
                        next = new Button(vars.getNextIcon());

                        add(cast,LEFT+10,TOP+10);
                        add(new Label("Quarto da família"),AFTER,SAME);
                        add(new Label("I Wasn't Born to Follow"),cast.getX(),AFTER);
                        add(new Label("The Byrds"),SAME,AFTER);
                        add(prev,SAME,AFTER+50);
                        add(play,AFTER,SAME);
                        add(next,AFTER,SAME);
                        resize();
                    }
                    public void onEvent(Event e){
                        if(e.target == play && e.type == ControlEvent.PRESSED){
                            status = !status;
                            if(status){
                                play.setImage(vars.getPauseIcon());
                                cast.setImage(vars.getCastOnIcon());
                            }
                            else{
                                play.setImage(vars.getPlayIcon());
                                cast.setImage(vars.getCastIcon());
                            }
                        }
                    }
                };
                options = new Button(vars.getMoreIcon());
                add(controls,LEFT,TOP);
                try{
                    img = new Image("img/media_player_family_room.png");
                    //CALCULAR ESCALA AINDA
                    prop_y = controls.getHeight()/(float)img.getHeight();
                    img = img.scaledBy(prop_y, prop_y);
                    imgctrl = new ImageControl(img);
                    add(imgctrl,AFTER,SAME);
                }catch(Exception e){}
                add(options,(int)(imgctrl.getX2()-(imgctrl.getWidth()/4)),(int)(imgctrl.getY()+10*prop_y));
                setBorderStyle(BORDER_ROUNDED);
                resize();
            }
            public void onEvent(Event e){
                if(e.target == options && e.type == ControlEvent.PRESSED){
                    Container detalhes_music = new Container(){
                        Label label_vol;
                        Image img;
                        ImageControl imgctrl;
                        Button prev;
                        Button play;
                        Button next;
                        Slider slider;
                        public void initUI(){
                            slider  = new Slider();
                            label_vol = new Label("20");
                            label_vol.setVisible(false);
                            prev = new Button(vars.getPrevIcon());
                            if(status){
                                play = new Button(vars.getPlayIcon());
                            }
                            else{
                                play = new Button(vars.getPauseIcon());
                            }
                            next = new Button(vars.getNextIcon());
                            try{
                                img = new Image("img/media_player_family_room.png");
                                img = img.scaledBy(0.1,0.1);
                                imgctrl = new ImageControl(img);
                                add(imgctrl,LEFT,TOP);
                            }catch(Exception e){}
                            add(new Label("Quarto da família"),AFTER+10,TOP);
                            add(new Label("I Wasn't Born to Follow"),AFTER+10,SAME);
                            add(new Label("1 hora atrás"),imgctrl.getX2()+10,AFTER);
                            resize();
                            add(new Label("The Byrds"),RIGHT,SAME);
                            add(prev,LEFT,imgctrl.getY2()+5);
                            add(play,AFTER,SAME);
                            add(next,AFTER,SAME);
                            try{
                            add(new ImageControl(new Image("icon/volume_icon.png")),imgctrl.getX2(),AFTER+10);
                            }catch(Exception e){}
                            add(slider,AFTER,SAME);
                            add(label_vol,SAME+(slider.getWidth()/2),SAME-20);
                            add(new ImageControl(vars.getPowerIcon()),imgctrl.getX2(),slider.getY2());
                            add(new ComboBox(new String[]{"a","b","c","d","e"}),AFTER,SAME);
                            resize();
                        }
                        public void onEvent(Event e){
                            if(e.target == slider){
                                if(e.type == 201){
                                    label_vol.setVisible(false);
                                }
                                else if(e.type == 203){
                                    label_vol.setVisible(true);
                                    label_vol.setText(Integer.toString(slider.getValue()));
                                }
                            }
                        }
                    };
                    Container historico_music = new Container(){
                        public void initUI(){
                            try{
                                add(new ImageControl(new Image("img/music_historico.png")),LEFT,TOP);
                            }catch(Exception e){}
                            resize();
                        }
                    };
                    PopUpMenu tw = new PopUpMenu(detalhes_music,"Detalhes",historico_music,"Historico");
                    tw.popup();
                }
            }
        };
        temperature_study = new Container(){
            public void initUI(){
                add(new Label("FALTANDO"),LEFT,TOP);
                resize();
            }
        };
        info = new Container(){
            public void initUI(){
                add(new Label("FALTANDO"),LEFT,TOP);
                resize();
            }
        };
        entretenimento = new Container(){
            public void initUI(){
                add(new Label("FALTANDO"),LEFT,TOP);
                resize();
            }
        };


            add(luzes_container,LEFT+20,TOP+10);
            add(campainha_container,SAME,AFTER+10);
            add(temperatura_container,AFTER+10,luzes_container.getY());
            add(seguranca_container,SAME,AFTER+10);
            add(planta_container,AFTER+10,luzes_container.getY());
            add(music_container,SAME+10,AFTER+10);
            add(temperature_study,SAME,AFTER+10);
            add(info,planta_container.getX2(),luzes_container.getY());
            add(entretenimento,SAME,AFTER);
            }
            public void onEvent(Event e){
                if((e.target == luzes_container || e.target == planta_container) && e.type == ControlEvent.PRESSED){
                    broadcastEvent(new ControlEvent(1508,this));
                }
            }
        };});
        SideMenuContainer.Item some = new SideMenuContainer.Item("Map", Resources.warning, ()-> {return new Container(){
            public void initUI(){
                
            }
        };});
		SideMenuContainer sideMenu = new SideMenuContainer(null, home,some);
        sideMenu.topMenu.header = new Container(){            
            public void initUI(){
                setBackColor(0x000000);
				Label title = new Label("SideMenu", CENTER, Color.WHITE, false);
				title.setForeColor(Color.WHITE);
				add(title, LEFT+45, BOTTOM-45, PARENTSIZE+40, DP+56);
			}
		};
		sideMenu.setBackColor(0x000000);
		sideMenu.setForeColor(Color.WHITE);
		sideMenu.setItemForeColor(Color.BLACK);
		sideMenu.topMenu.drawSeparators = true;
        sideMenu.topMenu.itemHeightFactor = 3;
		
        add(sideMenu, LEFT, TOP, PARENTSIZE, PARENTSIZE);
    }
}
