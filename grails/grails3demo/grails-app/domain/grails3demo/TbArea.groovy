package grails3demo

class TbArea {

    static mapping = {
        id generator: 'identity', column: 'id'
    }
    String area_code;
    String description;
    String lng;
    String lat;
    Integer iscity;
    Integer pid;
    Integer state;

    @Override
    public String toString() {
        return "TbArea{" +
                "description='" + description + '\'' +
                '}';
    }
}
