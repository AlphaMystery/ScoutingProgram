package falconrobotics.scoutingprogram;

/**
 * Created on 2/25/2016.
 *
 * Structure for how the data is going to be inputted into the pit table.
 */
public class Model_Pit {
    private int
            _id,
            driverXP,
            operatorXP,
            drivetrain,
            pneumatics,
            shooterType,
            shootingType,
            climb,
            climbSpeed,
            weight,
            portcullis,
            chevalDeFrise,
            moat,
            ramparts,
            drawbridge,
            sallyPort,
            rockWall,
            roughTerrain,
            lowBar,
            robotPhoto,
            syncNum;
    private String comments,
            robotDimensions;

    public Model_Pit(
            int _id,
            int driverXP,
            int operatorXP,
            int drivetrain,
            int pneumatics,
            int shooterType,
            int shootingType,
            int climb,
            int climbSpeed,
            int weight,
            String robotDimensions,
            int portcullis,
            int chevalDeFrise,
            int moat,
            int ramparts,
            int drawbridge,
            int sallyPort,
            int rockWall,
            int roughTerrain,
            int lowBar,
            String comments,
            int robotPhoto,
            int syncNum)
    {
        this._id = _id;
        this.driverXP = driverXP;
        this.operatorXP = operatorXP;
        this.drivetrain = drivetrain;
        this.pneumatics = pneumatics;
        this.shooterType = shooterType;
        this.shootingType = shootingType;
        this.climb = climb;
        this.climbSpeed = climbSpeed;
        this.weight = weight;
        this.robotDimensions = robotDimensions;
        this.portcullis = portcullis;
        this.chevalDeFrise = chevalDeFrise;
        this.moat = moat;
        this.ramparts = ramparts;
        this.drawbridge = drawbridge;
        this.sallyPort = sallyPort;
        this.rockWall = rockWall;
        this.roughTerrain = roughTerrain;
        this.lowBar = lowBar;
        this.comments = comments;
        this.robotPhoto = robotPhoto;
        this.syncNum = syncNum;
    }

    public String getRobotDimensions() {
        return robotDimensions;
    }

    public int getRoughTerrain() {
        return roughTerrain;
    }

    public void setRoughTerrain(int roughTerrain) {
        this.roughTerrain = roughTerrain;
    }

    public int getRockWall() {
        return rockWall;
    }

    public void setRockWall(int rockWall) {
        this.rockWall = rockWall;
    }

    public int getRobotPhoto() {
        return robotPhoto;
    }

    public void setRobotPhoto(int robotPhoto) {
        this.robotPhoto = robotPhoto;
    }

    public int getClimb() {
        return climb;
    }

    public void setClimb(int climb) {
        this.climb = climb;
    }

    public int getChevalDeFrise() {
        return chevalDeFrise;
    }

    public void setChevalDeFrise(int chevalDeFrise) {
        this.chevalDeFrise = chevalDeFrise;
    }

    public int getClimbSpeed() {
        return climbSpeed;
    }

    public void setClimbSpeed(int climbSpeed) {
        this.climbSpeed = climbSpeed;
    }

    public int getDrawbridge() {
        return drawbridge;
    }

    public void setDrawbridge(int drawbridge) {
        this.drawbridge = drawbridge;
    }

    public int getLowBar() {
        return lowBar;
    }

    public void setLowBar(int lowBar) {
        this.lowBar = lowBar;
    }

    public int getMoat() {
        return moat;
    }

    public void setMoat(int moat) {
        this.moat = moat;
    }

    public int getPortcullis() {
        return portcullis;
    }

    public void setPortcullis(int portcullis) {
        this.portcullis = portcullis;
    }

    public int getRamparts() {
        return ramparts;
    }

    public void setRamparts(int ramparts) {
        this.ramparts = ramparts;
    }

    public int getSallyPort() {
        return sallyPort;
    }

    public void setSallyPort(int sallyPort) {
        this.sallyPort = sallyPort;
    }

    public int getShooterType() {
        return shooterType;
    }

    public void setShooterType(int shooterType) {
        this.shooterType = shooterType;
    }

    public int getSyncNum() {
        return syncNum;
    }

    public void setSyncNum(int syncNum) {
        this.syncNum = syncNum;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(int drivetrain) {
        this.drivetrain = drivetrain;
    }

    public int getDriverXP() {
        return driverXP;
    }

    public void setDriverXP(int driverXP) {
        this.driverXP = driverXP;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getOperatorXP() {
        return operatorXP;
    }

    public void setOperatorXP(int operatorXP) {
        this.operatorXP = operatorXP;
    }

    public int getPneumatics() {
        return pneumatics;
    }

    public void setPneumatics(int pneumatics) {
        this.pneumatics = pneumatics;
    }

    public int getShootingType() {
        return shootingType;
    }

    public void setRobotDimensions(String robotDimensions) {
        this.robotDimensions = robotDimensions;
    }

    public int getWeight() {
        return weight;
    }

    public void setShootingType(int shootingType) {
        this.shootingType = shootingType;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
