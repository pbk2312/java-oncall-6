package oncall;

import oncall.controller.SheduleController;

public class Application {
    public static void main(String[] args) {
        SheduleController sheduleController = new SheduleController();
        sheduleController.run();
    }
}
