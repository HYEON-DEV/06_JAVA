public class ColorTV extends TV {
    private int colorCount;

    public int getColorCount() {
        return this.colorCount;
    }

    public void setColorCount(int colorCount) {
        this.colorCount = colorCount;
    }

    public void printInfo() {
        System.out.printf("%d인치 %d컬러\n", this.getSize(), this.getColorCount() );
    }
}
