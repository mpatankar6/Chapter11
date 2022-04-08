public class HanoiTower {
    private Peg peg1;
    private Peg peg2;
    private Peg peg3;
    private int numDiscs;

    public HanoiTower(int num)
    {
        this.numDiscs = num;
        this.peg1 = new Peg(1, num);
        this.peg2 = new Peg(2, num);
        this.peg3 = new Peg(3, num);

        // Add initial disks to the first peg
        for (int i = 5; i >= 1; i--) {
            peg1.addDisc(i);
        }


    }
    public void solveTower()
    {
        moveTower(peg1, peg3, peg2, numDiscs);
    }

    private void moveTower(Peg startPeg, Peg endPeg, Peg extraPeg, int numtoMove)
    {
        if (numtoMove == 1) {
            startPeg.moveTopDisc(endPeg);
        } else {
            startPeg.moveTopDisc(extraPeg);
            moveTower(startPeg, endPeg, extraPeg, numtoMove - 1);
        }



        // TODO move discs(number input) from the start peg to the end peg

    }
    public static void main(String[] args) {
        HanoiTower ht = new HanoiTower(5);
        ht.solveTower();
    }

}