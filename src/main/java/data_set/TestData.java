package data_set;

import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.List;

public class TestData {
    @DataProvider
    public Object[][] exodusEffectProvider(){
        int[] upsell1 = {0, 1};
        int[] upsell2 = {0, 1};
        int[] upsell3 = {0, 1};
        int[] upsell4 = {0, 1};
        int[] prayer = {0, 1};
        String[] country = {"United States"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int i =0; i < country.length; i++){
            for (int j = 0; j < prayer.length; j++){
                for (int k = 0; k < upsell1.length; k++){
                    for (int l = 0; l < upsell2.length; l++){
                        for(int m = 0; m < upsell3.length; m++){
                            for(int n = 0; n < upsell4.length; n++){
                                if(upsell1[k] == 1 && upsell2[l] == 1){
                                    continue;
                                }
                                if(upsell3[m] == 1 && upsell4[n] == 1){
                                    continue;
                                }
                                ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                innerArraylist.add(0, country[i]);
                                innerArraylist.add(1, prayer[j]);
                                innerArraylist.add(2, upsell1[k]);
                                innerArraylist.add(3, upsell2[l]);
                                innerArraylist.add(4, upsell3[m]);
                                innerArraylist.add(5, upsell4[n]);
                                outerArrayList.add(innerArraylist);
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][6];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 6; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"United States", 1, 1, 0, 0, 0},
                {"United States", 0, 0, 1, 0, 1},
                {"United States", 0, 0, 0, 0, 0},
                {"United States", 0, 0, 1, 0, 1},
                {"United States", 1, 0, 1, 1, 0},
                {"United States", 0, 0, 0, 0, 1},
        };
    }

    @DataProvider
    public Object[][] spanishExodusEffectProvider(){
        int[] upsell1 = {0, 1};
        int[] upsell2 = {0, 1};
        int[] upsell3 = {0, 1};
        int[] prayer = {0, 1};
        String[] country = {"Canada", "United States"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int i =0; i < country.length; i++){
            for (int j = 0; j < prayer.length; j++){
                for (int k = 0; k < upsell1.length; k++){
                    for (int l = 0; l < upsell2.length; l++){
                        for(int m = 0; m < upsell3.length; m++){
                            ArrayList<Object> innerArraylist = new ArrayList<Object>();
                            innerArraylist.add(0, country[i]);
                            innerArraylist.add(1, prayer[j]);
                            innerArraylist.add(2, upsell1[k]);
                            innerArraylist.add(3, upsell2[l]);
                            innerArraylist.add(4, upsell3[m]);
                            outerArrayList.add(innerArraylist);
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][5];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 5; j++){
                obj[i][j] = aux.get(j);
            }
        }
        return obj;
    }

    @DataProvider
    public Object[][] TOILProvider(){
        int[] upsell1 = {0, 1};
        int[] upsell2 = {0, 1};
        int[] upsell3 = {0, 1};
        int[] off = {0, 1};
        int[] insurance = {0, 1};
        String[] country = {"Canada", "United States"};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < bottles.length; o++){
            for (int i =0; i < country.length; i++){
                for (int j = 0; j < off.length; j++){
                    for (int k = 0; k < insurance.length; k++){
                        for (int l = 0; l < upsell1.length; l++){
                            for(int m = 0; m < upsell2.length; m++){
                                for(int n = 0; n < upsell3.length; n++){
                                    if(off[j] == 0 && insurance[k] == 1){
                                        continue;
                                    }
                                    if(upsell1[l] == 1 && upsell2[m] == 1){
                                        continue;
                                    }
                                    ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                    innerArraylist.add(0, bottles[o]);
                                    innerArraylist.add(1, country[i]);
                                    innerArraylist.add(2, off[j]);
                                    innerArraylist.add(3, insurance[k]);
                                    innerArraylist.add(4, upsell1[l]);
                                    innerArraylist.add(5, upsell2[m]);
                                    innerArraylist.add(6, upsell3[n]);
                                    outerArrayList.add(innerArraylist);
                                }
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][7];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 7; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"6b", "United States", 1 , 1, 1, 0, 1}
        };
    }

    @DataProvider
    public Object[][] IHProvider(){
        int[] upsell1 = {0, 1};
        int[] upsell2 = {0, 1};
        String[] upsell3 = {"0", "1b", "3b", "6b"};
        String[] upsell4 = {"0", "1b", "3b", "6b"};
        int[] off = {0, 1};
        int[] insurance = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < bottles.length; o++){
            for (int j = 0; j < off.length; j++){
                for (int k = 0; k < insurance.length; k++){
                    for (int l = 0; l < upsell1.length; l++){
                        for(int m = 0; m < upsell2.length; m++){
                            for(int n = 0; n < upsell3.length; n++){
                                for (int i =0; i < upsell4.length; i++){
                                    if(off[j] == 0 && insurance[k] == 1){
                                        continue;
                                    }
                                    if(upsell1[l] == 1 && upsell2[m] == 1){
                                        continue;
                                    }
                                    ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                    innerArraylist.add(0, bottles[o]);
                                    innerArraylist.add(1, off[j]);
                                    innerArraylist.add(2, insurance[k]);
                                    innerArraylist.add(3, upsell1[l]);
                                    innerArraylist.add(4, upsell2[m]);
                                    innerArraylist.add(5, upsell3[n]);
                                    innerArraylist.add(6, upsell4[i]);
                                    outerArrayList.add(innerArraylist);
                                }
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][7];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 7; j++){
                obj[i][j] = aux.get(j);
            }
        }
        return obj;
//        return new Object[][]{
//                {"1b", 0, 0, 0, 0, "0", "3b"}
//        };
    }

    @DataProvider
    public Object[][] DPHProvider(){
        int[] DPH6BottlesUpsell = {0, 1};
        int[] DPH3BottlesUpsell = {0, 1};
        int[] waterPitcher1CartridgeUpsell = {0, 1};
        int[] waterPitcher2CartridgeUpsell = {0, 1};
        int[] cartridge4Upsell = {0, 1};
        int[] cartridge2Upsell = {0, 1};
        int[] off = {0, 1};
        int[] insurance = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < bottles.length; o++){
            for (int j = 0; j < off.length; j++){
                for (int k = 0; k < insurance.length; k++){
                    for (int l = 0; l < DPH6BottlesUpsell.length; l++){
                        for(int m = 0; m < DPH3BottlesUpsell.length; m++){
                            for(int n = 0; n < waterPitcher1CartridgeUpsell.length; n++){
                                for (int i =0; i < waterPitcher2CartridgeUpsell.length; i++){
                                    for(int p = 0; p < cartridge4Upsell.length; p++){
                                        for (int q = 0; q < cartridge2Upsell.length; q++){
                                            if(waterPitcher1CartridgeUpsell[n] == 1 || waterPitcher2CartridgeUpsell[i] == 1 || (waterPitcher2CartridgeUpsell[i] == 0 && cartridge4Upsell[p] == 0 && cartridge2Upsell[q] == 0)){
                                                if(off[j] == 0 && insurance[k] == 1){
                                                    continue;
                                                }
                                                if(DPH6BottlesUpsell[l] == 1 && DPH3BottlesUpsell[m] == 1){
                                                    continue;
                                                }
                                                if(waterPitcher1CartridgeUpsell[n] == 1 && waterPitcher2CartridgeUpsell[i] == 1){
                                                    continue;
                                                }
                                                if(cartridge4Upsell[p] == 1 && cartridge2Upsell[q] == 1){
                                                    continue;
                                                }
                                                ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                                innerArraylist.add(0, bottles[o]);
                                                innerArraylist.add(1, off[j]);
                                                innerArraylist.add(2, insurance[k]);
                                                innerArraylist.add(3, DPH6BottlesUpsell[l]);
                                                innerArraylist.add(4, DPH3BottlesUpsell[m]);
                                                innerArraylist.add(5, waterPitcher1CartridgeUpsell[n]);
                                                innerArraylist.add(6, waterPitcher2CartridgeUpsell[i]);
                                                innerArraylist.add(7, cartridge4Upsell[p]);
                                                innerArraylist.add(8, cartridge2Upsell[q]);
                                                outerArrayList.add(innerArraylist);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][9];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 9; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"6b", 1, 1, 1, 0, 1, 0, 1, 0}
        };
    }

    @DataProvider
    public Object[][] EEBooksProvider(){

        return new Object[][]{
                {"DivinePet_eBook.pdf", 121446},
                {"ExodusEffect_eBook_v2.pdf", 1308248},
                {"LazarusEffect_eBook.pdf", 168143},
                {"HiddenPrayers_eBook.pdf", 136360},
        };
    }

    @DataProvider
    public Object[][] HighwayHealingBooksProvider(){

        return new Object[][]{
                {"HighwayHealing_eBook.pdf", 127683},
                {"ArmorOfGod_eBook_2021.pdf", 1776031},
                {"YourGardenOfEden_eBook.pdf", 216430},
                {"MedicineCabinetKillers_eBook.pdf", 1663557},
                {"TheDiseaseFreeLife_eBook.pdf", 132478},
                {"DivineVision_eBook.pdf", 107092},
        };
    }

    @DataProvider
    public Object[][] TheMemoryCovenantBooksProvider(){

        return new Object[][]{
                {"TheMemoryCovenant_eBook.pdf", 166847},
                {"SolomonsSecret_eBook.pdf", 111562},
                {"MemoryPrayers_eBook.pdf", 104764},
                {"BiblicalBrainGames_eBook.pdf", 2509831},
                {"SacredSmoothies_eBook.pdf", 358396},
        };
    }

    @DataProvider
    public Object[][] RRProvider(){

        return new Object[][]{
                {"RR"},
                {"RRLIVE"},
                {"RRLITE"},
                {"RRP"},
                {"RRB"},
                {"RR4U"}
        };
    }

    @DataProvider
    public Object[][] RR2Provider(){
        int[] retireLiveVip = {0, 1};
        int[] confessions = {0, 1};
        int[] retireLive = {0, 1};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < retireLive.length; o++){
            for (int j = 0; j < confessions.length; j++){
                for (int k = 0; k < retireLiveVip.length; k++){
                    ArrayList<Object> innerArraylist = new ArrayList<Object>();
                    innerArraylist.add(0, retireLive[o]);
                    innerArraylist.add(1, confessions[j]);
                    innerArraylist.add(2, retireLiveVip[k]);
                    outerArrayList.add(innerArraylist);
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][3];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 3; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {0, 0, 0},
//                {1, 1, 1}
        };
    }

    @DataProvider
    public Object[][] TCBDProvider(){
        int[] upsell1 = {0, 1};
        int[] upsell2 = {0, 1};
        int[] off = {0, 1};
        int[] insurance = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < bottles.length; o++){
            for (int j = 0; j < off.length; j++){
                for (int k = 0; k < insurance.length; k++){
                    for (int l = 0; l < upsell1.length; l++){
                        for(int m = 0; m < upsell2.length; m++){
                            if(off[j] == 0 && insurance[k] == 1){
                                continue;
                            }
                            if(upsell1[l] == 1 && upsell2[m] == 1){
                                continue;
                            }
                            ArrayList<Object> innerArraylist = new ArrayList<Object>();
                            innerArraylist.add(0, bottles[o]);
                            innerArraylist.add(1, off[j]);
                            innerArraylist.add(2, insurance[k]);
                            innerArraylist.add(3, upsell1[l]);
                            innerArraylist.add(4, upsell2[m]);
                            outerArrayList.add(innerArraylist);
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][5];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 5; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"6b", 1, 1, 1, 0}
        };
    }

    @DataProvider
    public Object[][] AGEProvider(){
        int[] upsell1 = {0, 1};
        int[] upsell2 = {0, 1};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int k = 0; k < upsell1.length; k++){
            for (int l = 0; l < upsell2.length; l++){
                ArrayList<Object> innerArraylist = new ArrayList<Object>();
                innerArraylist.add(0, upsell1[k]);
                innerArraylist.add(1, upsell2[l]);
                outerArrayList.add(innerArraylist);
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][2];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 2; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {1, 1}
        };
    }

    @DataProvider
    public Object[][] GFProvider(){
        String[] testoIgnite = {"0", "1b", "3b", "6b"};
        int[] gorillaFlowUpSell = {0, 1};
        int[] gorillaFlowDownSell = {0, 1};
        int[] off = {0, 1};
        int[] insurance = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < bottles.length; o++){
            for (int j = 0; j < off.length; j++){
                for (int k = 0; k < insurance.length; k++){
                    for (int l = 0; l < gorillaFlowUpSell.length; l++){
                        for(int m = 0; m < gorillaFlowUpSell.length; m++){
                            for(int n = 0; n < testoIgnite.length; n++){
                                if(off[j] == 0 && insurance[k] == 1){
                                    continue;
                                }
                                if(gorillaFlowUpSell[l] == 1 && gorillaFlowDownSell[m] == 1){
                                    continue;
                                }
                                ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                innerArraylist.add(0, bottles[o]);
                                innerArraylist.add(1, off[j]);
                                innerArraylist.add(2, insurance[k]);
                                innerArraylist.add(3, gorillaFlowUpSell[l]);
                                innerArraylist.add(4, gorillaFlowDownSell[m]);
                                innerArraylist.add(5, testoIgnite[n]);
                                outerArrayList.add(innerArraylist);
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][6];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 6; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"1b", 1 , 1, 1, 0, "0"},
                {"1b", 0 , 0, 0, 0, "1b"},
                {"1b", 1 , 0, 0, 1, "3b"},
                {"3b", 0 , 0, 1, 0, "6b"},
                {"3b", 1 , 1, 1, 0, "6b"},
                {"3b", 0 , 0, 0, 0, "3b"},
                {"6b", 1 , 0, 1, 0, "1b"},
                {"6b", 0 , 0, 0, 1, "0"},
                {"6b", 1 , 1, 1, 0, "1b"},
                {"6b", 0 , 0, 1, 0, "3b"},
        };
    }

    @DataProvider
    public Object[][] BUProvider(){
        String[] cellDivine = {"0", "1b", "3b", "6b"};
        int[] bioUnityUpSell = {0, 1};
        int[] bioUnityDownSell = {0, 1};
        int[] off = {0, 1};
        int[] insurance = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < bottles.length; o++){
            for (int j = 0; j < off.length; j++){
                for (int k = 0; k < insurance.length; k++){
                    for (int l = 0; l < bioUnityUpSell.length; l++){
                        for(int m = 0; m < bioUnityDownSell.length; m++){
                            for(int n = 0; n < cellDivine.length; n++){
                                if(off[j] == 0 && insurance[k] == 1){
                                    continue;
                                }
                                if(bioUnityUpSell[l] == 1 && bioUnityDownSell[m] == 1){
                                    continue;
                                }
                                ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                innerArraylist.add(0, bottles[o]);
                                innerArraylist.add(1, off[j]);
                                innerArraylist.add(2, insurance[k]);
                                innerArraylist.add(3, bioUnityUpSell[l]);
                                innerArraylist.add(4, bioUnityDownSell[m]);
                                innerArraylist.add(5, cellDivine[n]);
                                outerArrayList.add(innerArraylist);
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][6];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 6; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"6b", 1, 1, 1, 0, "6b"}
        };
    }

    @DataProvider
    public Object[][] DVProvider(){
        String[] divineDailyEnergy = {"0", "1b", "3b", "6b"};
        String[] dbOmegaPlus = {"0", "1b", "3b", "6b"};
        String[] gloryBiotics = {"0", "1b", "3b", "6b"};
        String[] dbGlucose16 = {"0", "1b", "3b", "6b"};
        String[] dbTurmeric = {"0", "1b", "3b", "6b"};
        int[] divineVisionUpSell = {0, 1};
        int[] divineVisionDownSell = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < bottles.length; o++){
            for (int j = 0; j < divineVisionUpSell.length; j++){
                for (int k = 0; k < divineVisionDownSell.length; k++){
                    for (int l = 0; l < dbTurmeric.length; l++){
                        for(int m = 0; m < dbGlucose16.length; m++){
                            for(int n = 0; n < gloryBiotics.length; n++){
                                for (int i = 0; i < dbOmegaPlus.length; i++){
                                    for (int p = 0; p < divineDailyEnergy.length; p++){
                                        if(divineVisionUpSell[j] == 1 && divineVisionDownSell[k] == 1){
                                            continue;
                                        }
                                        ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                        innerArraylist.add(0, bottles[o]);
                                        innerArraylist.add(1, divineVisionUpSell[j]);
                                        innerArraylist.add(2, divineVisionDownSell[k]);
                                        innerArraylist.add(3, dbTurmeric[l]);
                                        innerArraylist.add(4, dbGlucose16[m]);
                                        innerArraylist.add(5, gloryBiotics[n]);
                                        innerArraylist.add(6, dbOmegaPlus[i]);
                                        innerArraylist.add(7, divineDailyEnergy[p]);
                                        outerArrayList.add(innerArraylist);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][8];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 8; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"6b", 1, 0, "6b", "6b", "6b", "6b", "6b"}
        };
    }

    @DataProvider
    public Object[][] RRUProvider(){
        String[] probioMaxPlus = {"0", "1b", "3b", "6b"};
        String[] divineTurmeric = {"0", "1b", "3b", "6b"};
        int[] ringReliefUltraUpSell = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();
        for (int i = 0; i < bottles.length; i++) {
            for (int j = 0; j < ringReliefUltraUpSell.length; j++) {
                for (int k = 0; k < divineTurmeric.length; k++) {
                    for (int l = 0; l < probioMaxPlus.length; l++) {
                        ArrayList<Object> innerArraylist = new ArrayList<Object>();
                        innerArraylist.add(0, bottles[i]);
                        innerArraylist.add(1, ringReliefUltraUpSell[j]);
                        innerArraylist.add(2, divineTurmeric[k]);
                        innerArraylist.add(3, probioMaxPlus[l]);
                        outerArrayList.add(innerArraylist);
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][4];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 4; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"6b", 1, "6b", "6b"}
        };
    }

    @DataProvider
    public Object[][] APProvider(){
        String[] divineTurmeric = {"0", "1b", "3b", "6b"};
        int[] apostlePromiseDownSell = {0, 1};
        int[] apostlePromiseUpSell = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();
        for (int i = 0; i < bottles.length; i++) {
            for (int j = 0; j < apostlePromiseUpSell.length; j++) {
                for (int k = 0; k < apostlePromiseDownSell.length; k++) {
                    for (int l = 0; l < divineTurmeric.length; l++) {
                        if(apostlePromiseUpSell[j] == 1 && apostlePromiseDownSell[k] == 1){
                            continue;
                        }
                        ArrayList<Object> innerArraylist = new ArrayList<Object>();
                        innerArraylist.add(0, bottles[i]);
                        innerArraylist.add(1, apostlePromiseUpSell[j]);
                        innerArraylist.add(2, apostlePromiseDownSell[k]);
                        innerArraylist.add(3, divineTurmeric[l]);
                        outerArrayList.add(innerArraylist);
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][4];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 4; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"1b", 1, 0, "6b"}
        };
    }

    @DataProvider
    public Object[][] DADProvider(){
        int[] boss = {0, 1};
        int[] velocityUpSell = {0, 1};
        int[] velocityDownSell = {0, 1};
        int[] combatDefenseSecretsUpSell = {0, 1};
        int[] combatDefenseSecretsDownSell = {0, 1};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();
        for (int m = 0; m < boss.length; m++) {
            for (int i = 0; i < velocityUpSell.length; i++) {
                for (int j = 0; j < velocityDownSell.length; j++) {
                    for (int k = 0; k < combatDefenseSecretsUpSell.length; k++) {
                        for (int l = 0; l < combatDefenseSecretsDownSell.length; l++) {
                            if(velocityUpSell[i] == 1 && velocityDownSell[j] == 1){
                                continue;
                            }
                            if(combatDefenseSecretsUpSell[k] == 1 && combatDefenseSecretsDownSell[l] == 1){
                                continue;
                            }
                            ArrayList<Object> innerArraylist = new ArrayList<Object>();
                            innerArraylist.add(0, boss[m]);
                            innerArraylist.add(1, velocityUpSell[i]);
                            innerArraylist.add(2, velocityDownSell[j]);
                            innerArraylist.add(3, combatDefenseSecretsUpSell[k]);
                            innerArraylist.add(4, combatDefenseSecretsDownSell[l]);
                            outerArrayList.add(innerArraylist);
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][5];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 5; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {0, 0, 0, 0, 0},
//                {1, 1, 0, 1, 0}
        };
    }

    @DataProvider
    public Object[][] KFX3Provider(){
        int[] glucoDefend = {0, 1};
        int[] ketoDownSell = {0, 1};
        int[] ketoUpSell = {0, 1};
        int[] insurance = {0, 1};
        String[] bottles = {"bundle1", "bundle2", "bundle3", "bundle4"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();
        for (int i = 0; i < bottles.length; i++) {
            for (int j = 0; j < insurance.length; j++) {
                for (int k = 0; k < ketoUpSell.length; k++) {
                    for (int l = 0; l < ketoDownSell.length; l++) {
                        for (int m = 0; m < glucoDefend.length; m++){
                            if(ketoUpSell[k] == 1 && ketoDownSell[l] == 1){
                                continue;
                            }
                            ArrayList<Object> innerArraylist = new ArrayList<Object>();
                            innerArraylist.add(0, bottles[i]);
                            innerArraylist.add(1, insurance[j]);
                            innerArraylist.add(2, ketoUpSell[k]);
                            innerArraylist.add(3, ketoDownSell[l]);
                            innerArraylist.add(4, glucoDefend[l]);
                            outerArrayList.add(innerArraylist);
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][5];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 5; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"bundle4", 1, 0, 1, 1}
        };
    }

    @DataProvider
    public Object[][] AGEBonusesBooksProvider(){

        return new Object[][]{
                {"ebook-SlutHunt.pdf", 533899},
                {"ebook-LovePotion69.pdf", 508028},
                {"ebook-InnocentTouch.pdf", 331046},
        };
    }

    @DataProvider
    public Object[][] DADBooksProvider(){

        return new Object[][]{
                {"DarkAgeDefense.pdf", 3553995},
                {"WaterOnDemand.pdf", 1752044},
                {"ProduceOasis.pdf", 3571778},
                {"OffGridIndependence.pdf", 7023582},
                {"BulletProofBugout.pdf", 23659070},
        };
    }

    @DataProvider
    public Object[][] VelocityBooksProvider(){

        return new Object[][]{
                {"Velocity.pdf", 5921366},
                {"SurvivalSupplements.pdf", 2872683},
                {"SolarYielding.pdf", 1619826},
                {"AtHomeSurvivalPharmacy.pdf", 5389393},
        };
    }

    @DataProvider
    public Object[][] CombatDefenseSecretsBooksProvider(){

        return new Object[][]{
                {"CombatDefenseSecrets.pdf", 978944},
                {"CIABodyLanguageSecrets.pdf", 2206690},
                {"PsychologicalMindControl.pdf", 1523376},
        };
    }

    @DataProvider
    public Object[][] RRBooksProvider(){

        return new Object[][]{
                {"RetireRicher.pdf", 2246855}
        };
    }

    @DataProvider
    public Object[][] ConfessionsBooksProvider(){

        return new Object[][]{
                {"ConfessionsOfAHedgeFundManager1.pdf", 2246855},
                {"ConfessionsOfAHedgeFundManager2.pdf", 2246855}
        };
    }

    @DataProvider
    public Object[][] exodusSecretProvider(){
        int[] highWayHealingDownSell = {0, 1};
        int[] highWayHealingUpSell = {0, 1};
        int[] trinityOilDownSell2 = {0, 1};
        int[] trinityOilDownSell = {0, 1};
        int[] trinityOilUpSell = {0, 1};
        int[] prayer = {0, 1};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int i =0; i < prayer.length; i++){
            for (int j = 0; j < trinityOilUpSell.length; j++){
                for (int k = 0; k < trinityOilDownSell.length; k++){
                    for (int l = 0; l < trinityOilDownSell2.length; l++){
                        for(int m = 0; m < highWayHealingUpSell.length; m++){
                            for(int n = 0; n < highWayHealingDownSell.length; n++){
                                if(trinityOilUpSell[k] == 1 && trinityOilDownSell[l] == 1){
                                    continue;
                                }
                                if(trinityOilDownSell[k] == 1 && trinityOilDownSell2[l] == 1){
                                    continue;
                                }
                                if(trinityOilUpSell[k] == 1 && trinityOilDownSell2[l] == 1){
                                    continue;
                                }
                                if(highWayHealingUpSell[m] == 1 && highWayHealingDownSell[n] == 1){
                                    continue;
                                }
                                ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                innerArraylist.add(0, prayer[i]);
                                innerArraylist.add(1, trinityOilUpSell[j]);
                                innerArraylist.add(2, trinityOilDownSell[k]);
                                innerArraylist.add(3, trinityOilDownSell2[l]);
                                innerArraylist.add(4, highWayHealingUpSell[m]);
                                innerArraylist.add(5, highWayHealingDownSell[n]);
                                outerArrayList.add(innerArraylist);
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][6];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 6; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {1, 0, 0, 1, 0, 1}
        };
    }

    @DataProvider
    public Object[][] MYOHOCinnamonProvider(){
        int[] myohoCinnamonDownSell = {0, 1};
        int[] myohoCinnamonUpSell = {0, 1};
        int[] insurance = {0, 1};
        int[] off = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int i =0; i < bottles.length; i++){
            for (int m =0; m < off.length; m++) {
                for (int j = 0; j < insurance.length; j++) {
                    for (int k = 0; k < myohoCinnamonUpSell.length; k++) {
                        for (int l = 0; l < myohoCinnamonDownSell.length; l++) {
                            if (myohoCinnamonUpSell[k] == 1 && myohoCinnamonDownSell[l] == 1) {
                                continue;
                            }
                            if(off[m] == 0 && insurance[j] == 1){
                                continue;
                            }
                            ArrayList<Object> innerArraylist = new ArrayList<Object>();
                            innerArraylist.add(0, bottles[i]);
                            innerArraylist.add(1, off[m]);
                            innerArraylist.add(2, insurance[j]);
                            innerArraylist.add(3, myohoCinnamonUpSell[k]);
                            innerArraylist.add(4, myohoCinnamonDownSell[l]);
                            outerArrayList.add(innerArraylist);
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][5];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 5; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"1b", 0, 0, 0, 0}
        };
    }

    @DataProvider
    public Object[][] PPSProvider(){
        int[] lifetimeUpSell = {0, 1};
        String[] PPS = {"monthly", "yearly", "lifetime"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int i =0; i < PPS.length; i++){
            for (int m =0; m < lifetimeUpSell.length; m++) {
                ArrayList<Object> innerArraylist = new ArrayList<Object>();
                innerArraylist.add(0, PPS[i]);
                innerArraylist.add(1, lifetimeUpSell[m]);
                outerArrayList.add(innerArraylist);
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][2];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 2; j++){
                obj[i][j] = aux.get(j);
            }
        }
        return obj;
//        return new Object[][]{
//                {"1b", 0, 0, 0, 0}
//        };
    }

    @DataProvider
    public Object[][] EPProvider(){
        int[] endoBumpUpsell = {0, 1};
        int[] endoBumpDownSell = {0, 1};
        String[] testZilla = {"0", "1b", "3b", "6b"};
        String[] prostatePlus = {"0", "1b", "3b", "6b"};
        int[] off = {0, 1};
        int[] insurance = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < bottles.length; o++){
            for (int j = 0; j < off.length; j++){
                for (int k = 0; k < insurance.length; k++){
                    for (int l = 0; l < endoBumpUpsell.length; l++){
                        for(int m = 0; m < endoBumpDownSell.length; m++){
                            for(int n = 0; n < testZilla.length; n++){
                                for (int i =0; i < prostatePlus.length; i++){
                                    if(off[j] == 0 && insurance[k] == 1){
                                        continue;
                                    }
                                    if(endoBumpUpsell[l] == 1 && endoBumpDownSell[m] == 1){
                                        continue;
                                    }
                                    ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                    innerArraylist.add(0, bottles[o]);
                                    innerArraylist.add(1, off[j]);
                                    innerArraylist.add(2, insurance[k]);
                                    innerArraylist.add(3, endoBumpUpsell[l]);
                                    innerArraylist.add(4, endoBumpDownSell[m]);
                                    innerArraylist.add(5, testZilla[n]);
                                    innerArraylist.add(6, prostatePlus[i]);
                                    outerArrayList.add(innerArraylist);
                                }
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][7];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 7; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"1b", 0, 0, 0, 0, "1b", "1b"},
//                {"1b", 0, 0, 0, 0, "6b", "6b"},
//                {"1b", 0, 0, 0, 1, "1b", "1b"},
//                {"1b", 0, 0, 0, 1, "3b", "1b"},
//                {"1b", 0, 0, 0, 1, "6b", "3b"},
//                {"1b", 0, 0, 1, 0, "0", "3b"},
//                {"1b", 0, 0, 1, 0, "0", "6b"},
//                {"1b", 0, 0, 1, 0, "1b", "0"},
        };
    }

    @DataProvider
    public Object[][] INFGProvider(){
        int[] infinityGridUpSell1 = {0, 1};
        int[] infinityGridUpSell2 = {0, 1};
        int[] infinityGridUpSell3 = {0, 1};
        int[] insurance = {0, 1};
        String[] option = {"option1", "option2", "option3"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int i = 0; i < option.length; i++){
            for (int j = 0; j < insurance.length; j++){
                for (int l = 0; l < infinityGridUpSell1.length; l++){
                    for(int m = 0; m < infinityGridUpSell2.length; m++){
                        for(int n = 0; n < infinityGridUpSell3.length; n++){
                            if(infinityGridUpSell2[m] == 0 && infinityGridUpSell3[n] == 1){
                                continue;
                            }
                            if(infinityGridUpSell1[l] == 1 && infinityGridUpSell3[n] == 1){
                                continue;
                            }
                            ArrayList<Object> innerArraylist = new ArrayList<Object>();
                            innerArraylist.add(0, option[i]);
                            innerArraylist.add(1, insurance[j]);
                            innerArraylist.add(2, infinityGridUpSell1[l]);
                            innerArraylist.add(3, infinityGridUpSell2[m]);
                            innerArraylist.add(4, infinityGridUpSell3[n]);
                            outerArrayList.add(innerArraylist);
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][5];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 5; j++){
                obj[i][j] = aux.get(j);
            }
        }
//        return obj;
        return new Object[][]{
                {"option1", 0, 0, 0, 0},
//                {"option1", 0, 0, 0, 0},
//                {"option1", 0, 0, 0, 0}
        };
    }

    @DataProvider
    public Object[][] TTProvider(){
        int[] tupiTeaUpsell = {0, 1};
        int[] tupiTeaDownSell = {0, 1};
        String[] tupiTest = {"0", "1b", "3b", "6b"};
        String[] tupiFlow = {"0", "1b", "3b", "6b"};
        int[] off = {0, 1};
        int[] insurance = {0, 1};
        String[] bottles = {"1b", "3b", "6b"};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int o = 0; o < bottles.length; o++){
            for (int j = 0; j < off.length; j++){
                for (int k = 0; k < insurance.length; k++){
                    for (int l = 0; l < tupiTeaUpsell.length; l++){
                        for(int m = 0; m < tupiTeaDownSell.length; m++){
                            for(int n = 0; n < tupiTest.length; n++){
                                for (int i =0; i < tupiFlow.length; i++){
                                    if(off[j] == 0 && insurance[k] == 1){
                                        continue;
                                    }
                                    if(tupiTeaUpsell[l] == 1 && tupiTeaDownSell[m] == 1){
                                        continue;
                                    }
                                    ArrayList<Object> innerArraylist = new ArrayList<Object>();
                                    innerArraylist.add(0, bottles[o]);
                                    innerArraylist.add(1, off[j]);
                                    innerArraylist.add(2, insurance[k]);
                                    innerArraylist.add(3, tupiTeaUpsell[l]);
                                    innerArraylist.add(4, tupiTeaDownSell[m]);
                                    innerArraylist.add(5, tupiTest[n]);
                                    innerArraylist.add(6, tupiFlow[i]);
                                    outerArrayList.add(innerArraylist);
                                }
                            }
                        }
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][7];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 7; j++){
                obj[i][j] = aux.get(j);
            }
        }
        return obj;
//        return new Object[][]{
//                {"6b", 1, 1, 0, 0, "0", "0"},
//        };
    }

    @DataProvider
    public Object[][] FW5Provider(){
        int[] freedomWaterUpSell1 = {0, 1};
        int[] freedomWaterDownSell = {0, 1};
        int[] freedomWaterUpSell2 = {0, 1};
        int[] insurance = {0, 1};

        List<ArrayList<Object>> outerArrayList = new ArrayList<>();

        for (int k = 0; k < insurance.length; k++){
            for (int l = 0; l < freedomWaterUpSell1.length; l++){
                for(int m = 0; m < freedomWaterDownSell.length; m++){
                    for(int n = 0; n < freedomWaterUpSell2.length; n++){
                        if(freedomWaterUpSell1[l] == 1 && freedomWaterDownSell[m] == 1){
                            continue;
                        }
                        ArrayList<Object> innerArraylist = new ArrayList<Object>();
                        innerArraylist.add(0, insurance[k]);
                        innerArraylist.add(1, freedomWaterUpSell1[l]);
                        innerArraylist.add(2, freedomWaterDownSell[m]);
                        innerArraylist.add(3, freedomWaterUpSell2[n]);
                        outerArrayList.add(innerArraylist);
                    }
                }
            }
        }

        Object[][] obj = new Object[outerArrayList.size()][4];

        for (int i = 0; i < outerArrayList.size(); i++) {
            ArrayList<Object> aux = outerArrayList.get(i);
            for (int j = 0; j < 4; j++){
                obj[i][j] = aux.get(j);
            }
        }
        return obj;
    }
}
