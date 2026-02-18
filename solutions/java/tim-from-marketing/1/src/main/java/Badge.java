class Badge {
    public String print(Integer id, String name, String department) {
        String formattedId = null == id ? "" : "[" + id + "] - ";
        String formattedName = name + " - ";
        String formattedDepartment = null == department ? "OWNER" : department.toUpperCase();
        return formattedId + formattedName + formattedDepartment;
    }
}
