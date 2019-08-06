package Interfaces;

public interface Codes {

    String[] faultCodes = {
            "Clear",
            "Loop Fault Shutdown",
            "Ground Fault",
            "Noisy Device",
            "Device No Response",
            "Unconfigured Device Present",
            "High Device Identity Current",
            "Low Device Identity Current",
            "Invalid Device Identity",
            "Multiple Devices",
            "Device Fault",
            "Invalid Condition",
            "Low Long Term Average",
            "High Long Term Average",
            "Addr Loop Open Circuit",
            "Relay Or Sounder Stuck",
            "Callpoint Wiring Short Circuit",
            "Callpoint Wiring Open Circuit",
            "Detector Wiring Fault",
            "Power Wiring Open Circuit",
            "Power Wiring Short Circuit",
            "Contact Wiring Open Circuit",
            "Contact Wiring Short Circuit",
            "Battery Fault",
            "Charger Fault",
            "PSU Fault",
            "Mains Fault",
            "Battery Critical",
            "Sounder Fault",
            "Sounder Line Open Circuit",
            "Sounder Line Open Short Circuit",
            "Sounder EOL Fault",
            "LCD Display Failure",
            "Relay Coil Fault",
            "Wiring Fault Short Circuit",
            "Wiring Fault Open Circuit",
            "AirFlow Fault",
            "Earth Contact Fault",
            "Detector Condition Low Warning",
            "Detector Condition High Warning",
            "System Release Line Short Circuit",
            "System Release Line Open Circuit",
            "System Release Stuck",
            "No Net SuperVision",
            "Sounder No Response",
            "Door CTRL No Response",
            "Door CTRL Fault",
            "Door CTRL Line Open Circuit",
            "Door CTRL Line Short Circuit",
            "Door CTRL Stuck",
            "Extinguishing CTRL No Response",
            "Extinguishing CTRL Fault",
            "Extinguishing CTRL Line Open Circuit",
            "Extinguishing CTRL Line Short Circuit",
            "Extinguishing CTRL Stuck",
            "Alarm CTRL No Reponse",
            "Alarm CTRL Fault",
            "Alarm CTRL Line Open Circuit",
            "Alarm CTRL Line Short Circuit",
            "Alarm CTRL Stuck",
            "Firmware Incompatible",
            "Supervised Input Fault",
            "External PSU Lost",
            "Detector Power Up",
            "Calibration Fault",
            "Character Set Chip Invalid",
            "System Extinguishing Fault",
            "Loop Loading Fault",
            "Device Not Supported",
            "Late Poll",
            "Polling Error",
            "Window Fault",
            "Reserved",
            "Reserved",
            "Reserved",
            "Reserved",
            "Reserved",
            "Reserved",
            "Reserved",
            "Reserved",
            "Low Loop Voltage Fault",
            "Reserved",
            "Beam Fault",
            "Wrong Device Code",
            "OverLapping Devices",
            "Single Point Polling",
            "Low Temperature Fault",
            "CO Element Fault",
            "Optical Element Fault",
            "Temperature Too Low",
            "CO Sensor Age Warning",
            "CO Sensor Age Fault",
            "VDR Link Fault",
            "Download Required",
            "Auxiliary Voltage Fault",
            "Isolator Fault",
            "FBP Transmission Fault",
            "Toxic Gas Fault",
            "Auto Test Failed",
            "Detector Removed",
            "General Wiring Fault",
            "Performance Fault",
            "Vesda Urgent",
            "Vesda Minor",
            "Vesda PSU",
            "Beacon Fault",
            "General Fault",
            "High Current",
            "Supervised Input Signalling Fault",
            "Supervised Input General Fault",
            "HW Isolator Manual",
            "Detector Hardware Fault",
            "CallPoint Active Fault",
            "Point Info Changed",
            "WireLess Fault",
            "WireLess Low Battery",
            "WireLess Low Signal",
            "WireLess No Response",
            "DAS DC No Response",
            "DAS FC No Response",
            "Generic Over Current Protection",
            "Generic Current Range",
            "Generic Current Leakage",
            "Generic Low Voltage",
            "Generic High Voltage",
            "Generic Temperature Sensor",
            "Generic High Temperature",
            "Battery Impedance",
            "Battery Low Voltage",
            "Sounder Over Current Protection",
            "Extinguishing Over Current Protection",
            "Alarm Over Current Protection",
            "Sounder Current Range",
            "Extinguishing Current Range",
            "Alarm CTRL Current Range",
            "Sounder Relay Coil",
            "Extinguishing Relay Coil",
            "Alarm CTRL Relay Coil",
            "Generic Contact Stuck Fault",
            "Wrong System Voltage",
            "Generic Wiring Monitor SelfTest",
            "Sounder Wiring Monitor SelfTest",
            "Extinguishing Wiring Monitor SelfTest",
            "Alarm CTRL Wiring Monitor SelfTest",
            "Loop Restart Required",
            "Device Data Error",
            "Device ROM Fail",
            "Device RAM Fail",
            "Packet SEQ Error",
            "Packet Data Error",
            "Initialise Error"
    };

    String[] alarmCodes = {
            "Clear",
            "Pre-alarm",
            "Verifying",
            "Active",
            "Device Resetting",
            "Local Test",
            "Activate Warning"
    };

    String[] deviceCodes = {
            "IF 800 Ex IS-INT",                 //0
            "",                                 //1
            "SAM 800",                          //2
            "SAB 800",                          //3
            "S271I+",                           //4
            "MS802 Ex IS",                      //5
            "LPBD 800",                         //6
            "",                                 //7
            "",                                 //8
            "",                                 //9
            "",                                 //10
            "",                                 //11
            "",                                 //12
            "SIO 800",                          //13
            "SIO 800-INT",                      //14
            "BDM 800",                          //15
            "801 F",                            //16
            "801 F Ex",                         //17
            "MIO 800",                          //18
            "MIO 800-INT",                      //19
            "811 F",                            //20
            "811 FEx IS",                       //21
            "801 PC",                           //22
            "811 PC",                           //23
            "OR3-S1",                           //24
            "W3-S1",                            //25
            "HM3-D1",                           //26
            "ADK",                              //27
            "HM-STI",                           //28
            "OW3-S1",                           //29
            "IR3-S1",                           //30
            "HLA",                              //31
            "EANUE",                            //32
            "EAUE A",                           //33
            "EAUE E",                           //34
            "LAVI",                             //35
            "LAVII",                            //36
            "ALANZ",                            //37
            "SenSTI",                           //38
            "MelSTI",                           //39
            "ADKSTI",                           //40
            "UEASTI",                           //41
            "HL-STI",                           //42
            "SAB 801",                          //43
            "DDM 800 Loop",                     //44
            "DDM 800 Spur",                     //45
            "DDM 800",                          //46
            "801 PS",                           //47
            "816 H",                            //48
            "816 P",                            //49
            "816 PH",                           //50
            "TSM 800",                          //51
            "TSM 800-INT",                      //52
            "LPSY 800-R/W",                     //53
            "LPSY 865",                         //54
            "LPAV 800-R/W",                     //55
            "LPAV 865",                         //56
            "DDM 800 Loop (F CPoints)",         //57
            "DDM 800 SPUR(F CPoints) 1 Channel",//58
            "DDM 800 SPUR(F CPoints) 2 Channel",//59
            "LPSB 3000",                        //60
            "LPAV 3000",                        //61
            "VIO 800",                          //62
            "",                                 //63
            "",                                 //64
            "",                                 //65
            "",                                 //66
            "",                                 //67
            "",                                 //68
            "",                                 //69
            "",                                 //70
            "",                                 //71
            "",                                 //72
            "",                                 //73
            "",                                 //74
            "",                                 //75
            "",                                 //76
            "",                                 //77
            "850 PH",                           //78
            "",                                 //79
            "",                                 //80
            "850 P",                            //81
            "",                                 //82
            "850 H",                            //83
            "850 PC",                           //84
            "",                                 //85
            "801 CH Car Park",                  //86
            "QIO 850 2IO",                      //87
            "QIO 850 4IO",                      //88
            "QIO 850 4IN4OUT",                  //89
            "QMO 850 2IO",                      //90
            "QMO 850 4IO",                      //91
            "Supervised Digital Input",         //92
            "851 PHN",                          //93
            "460 PC",                           //94
            "840 PH",                           //95
            "840 P",                            //96
            "840 H",                            //97
            "840 PC",                           //98
            "QRM 850 2OUT",                     //99
            "QRM 850 4OUT",                     //100
            "830 PH",                           //101
            "830 P",                            //102
            "830 H",                            //103
            "830 PC",                           //104
            "830 PC Car Park",                  //105
            "850 PC Car Park",                  //106
            "FV 411 F",                         //107
            "FV 412 F",                         //108
            "FV 413 F",                         //109
            "FV 421 I",                         //110
            "SIO 800 MC",                       //111
            "SIO 800 MC-INT",                   //112
            "MCP 820",                          //113
            "MCP 820M",                         //114
            "MCP 830",                          //115
            "MCP 830M",                         //116
            "LPBS 800 - R/W",                   //117
            "LPBS 865 LP",                      //118
            "LPBS 3000",                        //119
            "",                                 //120
            "MCP 820 S",                        //121
            "MCP 830 S",                        //122
            "",                                 //123
            "",                                 //124
            "",                                 //125
            "",                                 //126
            "ALL",                              //127
            "NONE",                             //128
            "",                                 //129
            "",                                 //130
            "",                                 //131
            "",                                 //132
            "",                                 //133
            "",                                 //134
            "",                                 //135
            "",                                 //136
            "",                                 //137
            "",                                 //138
            "",                                 //139
            "P80SB",                            //140
            "P80S-R/W",                         //141
            "P85SR",                            //142
            "P80AIB",                           //143
            "P80AI-R/W",                        //144
            "P85AIR",                           //145
            "P80AVB",                           //146
            "P81AVB",                           //147
            "P80AV-R/W",                        //148
            "P85AVR",                           //149
            "P82AVR",                           //150
            "",                                 //151
            "",                                 //152
            "",                                 //153
            "",                                 //154
            "",                                 //155
            "",                                 //156
            "",                                 //157
            "",                                 //158
            "",                                 //159
            "",                                 //160
            "",                                 //161
            "",                                 //162
            "",                                 //163
            "",                                 //164
            "",                                 //165
            "",                                 //166
            "",                                 //167
            "",                                 //168
            "",                                 //169
            "",                                 //170
            "",                                 //171
            "",                                 //172
            "",                                 //173
            "",                                 //174
            "",                                 //175
            "",                                 //176
            "",                                 //177
            "",                                 //178
            "",                                 //179
            "",                                 //180
            "",                                 //181
            "",                                 //182
            "",                                 //183
            "",                                 //184
            "",                                 //185
            "",                                 //186
            "",                                 //187
            "",                                 //188
            "",                                 //189
            "",                                 //190
            "",                                 //191
            "",                                 //192
            "",                                 //193
            "",                                 //194
            "",                                 //195
            "801 H",                            //196
            "801 CH",                           //197
            "801 PH",                           //198
            "801 I",                            //199
            "811 H",                            //200
            "811 CH",                           //201
            "812 PH",                           //202
            "812 H",                            //203
            "812 PH",                           //204
            "812 I",                            //205
            "812 IA",                           //206
            "",                                 //207
            "",                                 //208
            "GAR 800",                          //209
            "GARA 800",                         //210
            "LPS 800",                          //211
            "MIM 800",                          //212
            "MIM 800-US",                       //213
            "APM 800",                          //214
            "RIM 800",                          //215
            "RMS 800",                          //216
            "SNM 800",                          //217
            "S271f+",                           //218
            "LAV 800",                          //219
            "CP 820",                           //220
            "CP 830",                           //221
            "CP 820M",                          //222
            "CP 830M",                          //223
            "DIN 820",                          //224
            "DIN 830",                          //225
            "DIM 800",                          //226
            "DIM 800-US",                       //227
            "DIM 800-INT",                      //228
            "DIM 800-US-INT",                   //229
            "CIM 800",                          //230
            "CIM 800-US",                       //231
            "CIM 800-INT",                      //232
            "CIM 800-US-INT",                   //233
            "Digital Input",                    //234
            "Toggling digital input",           //235
            "Digital output",                   //236
            "Digital visual o/p",               //237
            "",                                 //238
            "Digital supervised output",        //239
            "",                                 //240
            "",                                 //241
            "812ID",                            //242
            "812PD",                            //243
            "",                                 //244
            "VLC 800",                          //245
            "",                                 //246
            "MIM 800-INT",                      //247
            "813 P",                            //248
            "DIO 800",                          //249
            "DIO 800-INT",                      //250
            "801 PHEx IS",                      //251
            "801 CHEx IS",                      //252
            "801 HEx IS",                       //253
            "CP 840Ex IS",                      //254
            "IF 800 Ex IS"                      //255
    };
}
