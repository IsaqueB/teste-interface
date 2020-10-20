package com.totalcross;

import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.image.*;

public class sys_vars {
    private boolean luzes_check;
    private boolean kitchen_check;
    private boolean living_room_check;
    private boolean porch_check;
    private boolean garage_check;
    private Image x_icon;
    private Image restore_icon;
    private Image lamp_icon;
    private Image walk_icon;
    private Image home_icon;
    private Image power_icon;
    private Image hot_icon;
    private Image cold_icon;
    private Image check_icon;
    private Image more_icon;
    private Image up_icon;
    private Image down_icon;
    private Image security_icon;
    private Image camera_icon;
    private Image door_icon;
    private Image eye_icon;
    private Image stop_icon;
    private Image cast_icon;
    private Image cast_on_icon;
    private Image play_icon;
    private Image pause_icon;
    private Image next_icon;
    private Image prev_icon;
    private Container front_door_ring_container;
    private Container front_door_motion_container;
    private Container front_door_last_ring_container;
    private Container front_door_last_motion_container;

    public sys_vars() {
        luzes_check = false;
        kitchen_check = false;
        living_room_check = false;
        porch_check = false;
        garage_check = false;
        try {// X_ICON
            x_icon = new Image("icon/x_icon.png");
        } catch (Exception e) {
        }
        try {// RESTORE_ICON
            restore_icon = new Image("icon/restore_icon.png");
        } catch (Exception e) {
        }
        try {// LAMP_ICON
            lamp_icon = new Image("icon/lamp_icon.png");
        } catch (Exception e) {
        }
        try {// WALK_ICON
            walk_icon = new Image("icon/walk_icon.png");
        } catch (Exception e) {
        }
        try {// HOME_ICON
            home_icon = new Image("icon/home_icon.png");
        } catch (Exception e) {
        }
        try {// POWER_ICON
            power_icon = new Image("icon/power_icon.png");
        } catch (Exception e) {
        }
        try {// HOT_ICON
            hot_icon = new Image("icon/fire_icon.png");
        } catch (Exception e) {
        }
        try {// COLD_ICON
            cold_icon = new Image("icon/ice_icon.png");
        } catch (Exception e) {
        }
        try {// CHECK_ICON
            check_icon = new Image("icon/check_icon.png");
        } catch (Exception e) {
        }
        try {// MORE_ICON
            more_icon = new Image("icon/more_vert_icon.png");
        } catch (Exception e) {}
        try {// UP_ICON
            up_icon = new Image("icon/up_icon.png");
        } catch (Exception e) {}
        try {// DOWN_ICON
            down_icon = new Image("icon/down_icon.png");
        } catch (Exception e) {}
        try{//SECURITY
            security_icon = new Image("icon/security_icon.png");
        } catch (Exception e){}
        try{//CAMERA
            camera_icon = new Image("icon/camera_icon.png");
        } catch (Exception e){}
        try{//DOOR
            door_icon = new Image("icon/door_icon.png");
        }catch(Exception e){}
        try{//EYE
            eye_icon = new Image("icon/eye_icon.png");
        }catch(Exception e){}
        try{//STOP
            stop_icon = new Image("icon/stop_icon.png");
        }catch(Exception e){}
        try{
            cast_icon = new Image("icon/cast_icon.png");
        }catch(Exception e){}
        try{
            cast_on_icon = new Image("icon/cast_connected_icon.png");
        }catch(Exception e){}
        try{//PLAY
            play_icon = new Image("icon/play_icon.png");
        }catch(Exception e){}
        try{//PAUSE
            pause_icon = new Image("icon/pause_icon.png");
        }catch(Exception e){}
        try{//NEXT
            next_icon = new Image("icon/next_icon.png");
        }catch(Exception e){}
        try{//PREV
            prev_icon = new Image("icon/prev_icon.png");
        }catch(Exception e){}

        front_door_ring_container = new Container() { // CONTAINER PARA O FRONT DOOR RING
            public void initUI() {
                Image front_door_ring_img;
                Label front_door_ring_label = new Label("Front Door Ring");
                Label last_ring_label = new Label("36 minutos atrás");
                Label last_stage_label = new Label("Desocupado");
                Label device_id_label = new Label("device id");
                Label device_id_aux_label = new Label("e04f434dca02");
                Label firmware_label = new Label("firmare");
                Label firmware_aux_label = new Label("Up to date");
                Label timezone_label = new Label("timezone");
                Label timezone_aux_label = new Label("America/New_York");
                try {// HOME_ICON
                    add(new ImageControl(home_icon), LEFT + 5, TOP + 10);
                } catch (Exception e) {
                }
                add(front_door_ring_label, AFTER + 10, TOP);
                add(last_stage_label, AFTER + 50, SAME);
                add(last_ring_label, front_door_ring_label.getX(), AFTER);
                try {
                    front_door_ring_img = new Image("img/front_door_ring_img.png");
                    add(new ImageControl(front_door_ring_img), LEFT, AFTER);
                } catch (Exception e) {
                }
                this.resize();
                add(device_id_label, SAME + 10, AFTER);
                add(firmware_label, SAME, AFTER);
                add(timezone_label, SAME, AFTER);
                add(device_id_aux_label, AFTER + 50, device_id_label.getY());
                add(firmware_aux_label, SAME, AFTER);
                add(timezone_aux_label, SAME, AFTER);

            }
        };

        front_door_motion_container = new Container() { // CONTAINER PARA O FRONT DOOR MOTION
            public void initUI() {
                Image front_door_motion_img;
                Label front_door_motion_label = new Label("Front Door Motion");
                Label last_motion_label = new Label("5 horas atrás");
                Label last_stage_label = new Label("Desligado");
                Label device_id_label = new Label("device id");
                Label device_id_aux_label = new Label("e04f434dca02");
                Label firmware_label = new Label("firmware");
                Label firmware_aux_label = new Label("Up to date");
                Label timezone_label = new Label("timezone");
                Label timezone_aux_label = new Label("America/New_York");
                try {// WALK_ICON
                    add(new ImageControl(walk_icon), LEFT + 5, TOP + 10);
                } catch (Exception e) {
                }
                add(front_door_motion_label, AFTER + 10, TOP);
                add(last_stage_label, AFTER + 50, SAME);
                add(last_motion_label, front_door_motion_label.getX(), AFTER);
                try {
                    front_door_motion_img = new Image("img/front_door_motion_img.png");
                    add(new ImageControl(front_door_motion_img), LEFT, AFTER);
                } catch (Exception e) {
                }
                this.resize();
                add(device_id_label, SAME + 10, AFTER);
                add(firmware_label, SAME, AFTER);
                add(timezone_label, SAME, AFTER);
                add(device_id_aux_label, AFTER + 50, device_id_label.getY());
                add(firmware_aux_label, SAME, AFTER);
                add(timezone_aux_label, SAME, AFTER);

            }
        };

        front_door_last_ring_container = new Container() { // CONTAINER PARA O FRONT DOOR LAST RING
            public void initUI() {
                Image front_door_last_ring_img;
                Label front_door_lring_label = new Label("Front Door Last Ring");
                Label last_lring_label = new Label("5 horas atrás");
                Label last_hour_label = new Label("06:44");
                Label answered_label = new Label("answered");
                Label answered_aux_label = new Label("false");
                try {// RESTORE_ICON
                    restore_icon = new Image("icon/restore_icon.png");
                } catch (Exception e) {
                }
                add(front_door_lring_label, AFTER + 10, TOP);
                add(last_hour_label, AFTER + 50, SAME);
                add(last_lring_label, front_door_lring_label.getX(), AFTER);
                try {
                    front_door_last_ring_img = new Image("img/front_door_last_ring_img.png");
                    add(new ImageControl(front_door_last_ring_img), LEFT, AFTER);
                } catch (Exception e) {
                }
                this.resize();
                add(answered_label, SAME + 10, AFTER);
                add(answered_aux_label, AFTER + 50, SAME);

            }
        };

        front_door_last_motion_container = new Container() { // CONTAINER PARA O FRONT DOOR LAST MOTION
            public void initUI() {
                Image front_door_last_motion_img;
                Label front_door_lmotion_label = new Label("Front Door Last Motion");
                Label last_lmotion_label = new Label("5 horas atrás");
                Label last_hour_label = new Label("13:21");
                Label answered_label = new Label("answered");
                Label answered_aux_label = new Label("false");
                try {// RESTORE_ICON
                    restore_icon = new Image("icon/restore_icon.png");
                } catch (Exception e) {
                }
                add(front_door_lmotion_label, AFTER + 10, TOP);
                add(last_hour_label, AFTER + 50, SAME);
                add(last_lmotion_label, front_door_lmotion_label.getX(), AFTER);
                try {
                    front_door_last_motion_img = new Image("img/front_door_last_motion_img.png");
                    add(new ImageControl(front_door_last_motion_img), LEFT, AFTER);
                } catch (Exception e) {
                }
                this.resize();
                add(answered_label, SAME + 10, AFTER);
                add(answered_aux_label, AFTER + 50, SAME);

            }
        };
    }

    void setLuzesCheck(boolean check) {
        luzes_check = check;
    }

    void setKitchenCheck(boolean check) {
        kitchen_check = check;
    }

    void setLivingRoomCheck(boolean check) {
        living_room_check = check;
    }

    void setPorchCheck(boolean check) {
        porch_check = check;
    }

    void setGarageCheck(boolean check) {
        garage_check = check;
    }

    boolean getLuzesCheck() {
        return luzes_check;
    }

    boolean getKitchenCheck() {
        return kitchen_check;
    }

    boolean getLivingRoomCheck() {
        return living_room_check;
    }

    boolean getPorchCheck() {
        return porch_check;
    }

    boolean getGarageCheck() {
        return garage_check;
    }

    Image getXIcon() {
        return x_icon;
    }

    Image getRestoreIcon() {
        return restore_icon;
    }

    Image getLampIcon() {
        return lamp_icon;
    }

    Image getWalkIcon() {
        return walk_icon;
    }

    Image getHomeIcon() {
        return home_icon;
    }

    Image getPowerIcon() {
        return power_icon;
    }

    Image getHotIcon() {
        return hot_icon;
    }

    Image getColdIcon() {
        return cold_icon;
    }

    Image getCheckIcon() {
        return check_icon;
    }

    Image getMoreIcon() {
        return more_icon;
    }
    Image getUpIcon() {
        return up_icon;
    }
    Image getDownIcon() {
        return down_icon;
    }
    Image getSecurityIcon(){
        return security_icon;
    }
    Image getCameraIcon(){
        return camera_icon;
    }
    Image getDoorIcon(){
        return door_icon;
    }
    Image getEyeIcon(){
        return eye_icon;
    }
    Image getStopIcon(){
        return stop_icon;
    }
    Image getCastIcon(){
        return cast_icon;
    }
    Image getCastOnIcon(){
        return cast_on_icon;
    }
    Image getPlayIcon(){
        return play_icon;
    }
    Image getPauseIcon(){
        return pause_icon;
    }
    Image getNextIcon(){
        return next_icon;
    }
    Image getPrevIcon(){
        return prev_icon;
    }

    Container getFrontDoorRingContainer() {
        return front_door_ring_container;
    }

    Container getFrontDoorMotionContainer() {
        return front_door_motion_container;
    }

    Container getFrontDoorLastRingContainer() {
        return front_door_last_ring_container;
    }

    Container getFrontDoorLastMotionContainer() {
        return front_door_last_motion_container;
    }
    Container getHistorico(String caminho){
        Container container = new Container(){
            public void initUI(){
                try{
                    add(new ImageControl(new Image(caminho)),TOP,LEFT);
                    add(new ImageControl(new Image("img/historico_temp")),SAME,AFTER);
                }
                catch(Exception e){}
                add(new Label("a"),TOP,LEFT);
                resize();
            }
        };
        return container;
    }
}
