class LoopFilter:

    def getLoopByte(String loopVal):

        loopByte = 0;
        switch(loopVal) :
            case "Loop A":
                loopByte = 1;
                break;
            case "Loop B":
                loopByte = 2;
                break;
            case "Loop C":
                loopByte = 3;
                break;
            case "Loop D":
                loopByte = 4;
                break;
            case "Loop E":
                loopByte = 5;
                break;
            case "Loop F":
                loopByte = 6;
                break;
            case "Loop G":
                loopByte = 7;
                break;
            case "Loop H":
                loopByte = 8;
                break;
            default:
                loopByte = 0;
                break;

        return loopByte;

    def getLoopString(int loopByte):

        loopString = "";
        switch(loopByte):

            case 1:
                loopString = "Loop A";
                break;
            case 2:
                loopString = "Loop B";
                break;
            case 3:
                loopString = "Loop C";
                break;
            case 4:
                loopString = "Loop D";
                break;
            case 5:
                loopString = "Loop E";
                break;
            case 6:
                loopString = "Loop F";
                break;
            case 7:
                loopString = "Loop G";
                break;
            case 8:
                loopString = "Loop H";
                break;
            default:
                loopString = "Loop Unknown";
                break;

        return loopString;
