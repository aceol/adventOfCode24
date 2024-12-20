import java.io.File
import kotlin.math.abs

fun main() {
   // day1Step1()
   // day1Step2()
  //  day021();
   day031();
}


val left = mutableListOf<Int>(58789,
    27059,
    86784,
    72958,
    95228,
    77437,
    33685,
    99368,
    41094,
    70702,
    67914,
    60325,
    25043,
    59623,
    57390,
    68803,
    24268,
    65399,
    97762,
    50114,
    88373,
    49024,
    96953,
    43964,
    84426,
    76079,
    22861,
    91048,
    74780,
    49960,
    91972,
    52862,
    62546,
    92384,
    80234,
    98465,
    34696,
    84984,
    32047,
    20926,
    79049,
    61387,
    40584,
    92492,
    37042,
    24478,
    10848,
    96010,
    21014,
    89706,
    51308,
    87493,
    20912,
    27054,
    57804,
    47423,
    68652,
    86295,
    49216,
    25463,
    20700,
    48643,
    73701,
    81231,
    43227,
    22496,
    98833,
    54707,
    24668,
    69702,
    82025,
    40061,
    16121,
    64440,
    79108,
    51027,
    68719,
    23563,
    83622,
    57297,
    61983,
    12603,
    23669,
    52072,
    78049,
    23990,
    22137,
    90938,
    55725,
    59993,
    54578,
    92115,
    38969,
    81101,
    93794,
    64839,
    47311,
    78166,
    87125,
    66623,
    88110,
    72660,
    41748,
    91564,
    12219,
    60138,
    54590,
    62975,
    61842,
    26272,
    27007,
    48169,
    94898,
    22706,
    56283,
    29521,
    36845,
    88825,
    29862,
    81174,
    13711,
    53878,
    87590,
    99631,
    82834,
    78342,
    28790,
    36906,
    14336,
    76519,
    87574,
    63709,
    39632,
    29645,
    81798,
    81713,
    22679,
    38591,
    14714,
    14080,
    63166,
    13932,
    83688,
    90711,
    90434,
    71866,
    28566,
    20439,
    37224,
    77827,
    64745,
    26417,
    64271,
    81563,
    12278,
    15257,
    97652,
    10946,
    81470,
    47816,
    29783,
    62569,
    71904,
    55555,
    30111,
    97322,
    84274,
    25514,
    19013,
    84608,
    99317,
    77083,
    14626,
    50572,
    21558,
    68710,
    50579,
    98946,
    57049,
    34217,
    88561,
    38428,
    35301,
    68659,
    78548,
    38423,
    25602,
    26663,
    39416,
    35875,
    23721,
    58006,
    52580,
    95373,
    12865,
    72652,
    78586,
    94022,
    25025,
    42121,
    87831,
    48850,
    83055,
    52315,
    93089,
    25700,
    72511,
    39725,
    80667,
    70151,
    92383,
    55177,
    59932,
    42058,
    56115,
    44800,
    74334,
    12524,
    88761,
    83983,
    29874,
    57987,
    99851,
    33458,
    79218,
    59543,
    21709,
    19922,
    41425,
    13866,
    49725,
    51423,
    59245,
    87806,
    79982,
    28132,
    56313,
    37423,
    21631,
    90163,
    64701,
    69835,
    63939,
    69441,
    90631,
    54776,
    25224,
    82457,
    92005,
    18636,
    66705,
    57104,
    48735,
    94866,
    83090,
    40897,
    88797,
    85498,
    30190,
    66064,
    29791,
    66255,
    41250,
    94161,
    54325,
    45766,
    33824,
    45441,
    85065,
    15504,
    91128,
    47086,
    62989,
    46684,
    21394,
    85025,
    30167,
    63007,
    92712,
    90022,
    64112,
    32922,
    82947,
    27408,
    92065,
    60699,
    45185,
    81565,
    43850,
    90819,
    67506,
    40142,
    59876,
    73904,
    21431,
    85880,
    75274,
    63975,
    42859,
    45645,
    34062,
    41145,
    58221,
    41790,
    34067,
    75883,
    64882,
    92004,
    54170,
    53032,
    41443,
    24191,
    68372,
    62823,
    92170,
    79184,
    38988,
    16245,
    61971,
    58462,
    13669,
    95491,
    80368,
    54437,
    49667,
    57601,
    36103,
    61752,
    87154,
    11458,
    95020,
    74407,
    76364,
    74924,
    74178,
    28787,
    30643,
    97779,
    18060,
    33280,
    19928,
    16465,
    96623,
    35706,
    19824,
    79474,
    46368,
    81026,
    74845,
    87992,
    10511,
    17541,
    99200,
    92088,
    30102,
    95669,
    31323,
    49087,
    13654,
    41957,
    69672,
    73457,
    69851,
    51708,
    81752,
    42100,
    65676,
    67173,
    56955,
    47605,
    56609,
    96803,
    20037,
    84578,
    73603,
    26774,
    69717,
    25769,
    65193,
    68993,
    31290,
    35905,
    75221,
    71743,
    15429,
    88883,
    53273,
    53474,
    30423,
    87208,
    21922,
    56981,
    84407,
    92502,
    44701,
    37137,
    46656,
    85169,
    42787,
    32009,
    76537,
    75936,
    64069,
    94775,
    11066,
    96942,
    39943,
    99820,
    82222,
    67201,
    45047,
    52846,
    31925,
    75095,
    67559,
    70255,
    14881,
    66111,
    52776,
    48217,
    27533,
    76862,
    93730,
    19119,
    20793,
    28844,
    75809,
    79954,
    89143,
    15920,
    98309,
    61390,
    91590,
    36942,
    43612,
    62280,
    81905,
    69500,
    30016,
    37738,
    97736,
    95453,
    83841,
    89661,
    54880,
    30171,
    43651,
    32991,
    77834,
    86698,
    54669,
    86168,
    20582,
    63078,
    40364,
    48964,
    91274,
    23554,
    62116,
    47249,
    65442,
    87647,
    67752,
    69385,
    35212,
    55866,
    86864,
    17913,
    70472,
    78816,
    74722,
    69344,
    69289,
    67116,
    17178,
    54049,
    10096,
    10933,
    17904,
    73750,
    24618,
    55226,
    95001,
    77839,
    57111,
    24177,
    86576,
    44614,
    81490,
    24759,
    11287,
    74785,
    27583,
    30172,
    89894,
    42508,
    25556,
    18793,
    32941,
    99728,
    28210,
    27008,
    84393,
    65829,
    49816,
    73908,
    22824,
    27756,
    84212,
    51194,
    50248,
    13587,
    54561,
    14733,
    53055,
    31145,
    16865,
    96415,
    87252,
    58918,
    43096,
    27809,
    76384,
    90593,
    94850,
    84649,
    70914,
    37245,
    15256,
    95830,
    72468,
    68165,
    49990,
    30245,
    80177,
    19102,
    60883,
    94584,
    11629,
    83942,
    98428,
    29707,
    36468,
    86820,
    21262,
    60331,
    29379,
    48953,
    73148,
    97913,
    24039,
    43317,
    34623,
    14581,
    97267,
    29237,
    83091,
    46331,
    69602,
    28519,
    14318,
    26144,
    28648,
    37188,
    95949,
    44407,
    49859,
    46623,
    75981,
    57484,
    85229,
    82977,
    10758,
    10279,
    37576,
    94624,
    95947,
    69892,
    81444,
    13092,
    14868,
    33930,
    57471,
    72588,
    41668,
    10306,
    87273,
    41744,
    35868,
    53133,
    75783,
    10074,
    53205,
    92488,
    38198,
    20120,
    78344,
    99876,
    69062,
    43840,
    48500,
    59750,
    67216,
    16906,
    98034,
    41621,
    93818,
    61664,
    45369,
    20507,
    82793,
    87708,
    36898,
    52570,
    36679,
    26649,
    75507,
    31553,
    17591,
    22067,
    48812,
    49198,
    26002,
    42947,
    12950,
    71406,
    22795,
    87872,
    78226,
    94380,
    56778,
    63451,
    16336,
    20682,
    41020,
    73814,
    82170,
    25087,
    30733,
    70801,
    31083,
    87063,
    42217,
    10510,
    56707,
    13172,
    53337,
    25513,
    39676,
    48497,
    98346,
    17160,
    14191,
    86557,
    12936,
    66657,
    14496,
    10452,
    27873,
    57301,
    84746,
    11640,
    11240,
    13244,
    29407,
    72524,
    70776,
    78168,
    45118,
    95654,
    63910,
    52213,
    71429,
    55261,
    40819,
    77021,
    62939,
    43136,
    54571,
    61525,
    78329,
    16417,
    24710,
    98654,
    11417,
    97222,
    36533,
    63037,
    33935,
    85633,
    53326,
    38602,
    64320,
    84394,
    22214,
    40603,
    12038,
    91760,
    30962,
    69928,
    91548,
    61270,
    52543,
    96907,
    94862,
    36867,
    78178,
    96175,
    18313,
    29518,
    47176,
    16043,
    98613,
    24524,
    50079,
    50392,
    96483,
    23704,
    79804,
    59352,
    28734,
    66932,
    84652,
    81233,
    61813,
    39414,
    61577,
    52142,
    99269,
    65597,
    76283,
    59366,
    96758,
    34965,
    53408,
    15500,
    47748,
    21807,
    43690,
    58602,
    64122,
    54427,
    64093,
    14460,
    89611,
    63056,
    80641,
    20065,
    53759,
    53429,
    33664,
    98954,
    18508,
    73654,
    36749,
    38704,
    58398,
    15407,
    79946,
    65603,
    37739,
    10565,
    12705,
    53419,
    76095,
    74185,
    38692,
    35982,
    20938,
    99256,
    21586,
    77045,
    83458,
    68485,
    19772,
    24490,
    82581,
    62633,
    39624,
    28147,
    53778,
    37875,
    95920,
    25986,
    97541,
    52877,
    94093,
    68569,
    93531,
    72106,
    88416,
    54125,
    98451,
    22883,
    70670,
    19738,
    87304,
    12339,
    10831,
    99160,
    51288,
    93577,
    84192,
    43597,
    92837,
    21981,
    53101,
    61701,
    23547,
    34215,
    90974,
    85904,
    14327,
    91673,
    55493,
    97416,
    64549,
    57965,
    58101,
    18375,
    69653,
    69096,
    87334,
    41580,
    11874,
    44957,
    86634,
    51588,
    92199,
    88542,
    22393,
    68666,
    39369,
    46682,
    76689,
    47130,
    13334,
    81359,
    25479,
    91035,
    86432,
    10750,
    22408,
    30205,
    17589,
    37538,
    22262,
    16278,
    24024,
    91132,
    94767,
    70645,
    88760,
    94730,
    13825,
    23899,
    22721,
    78866,
    40381,
    67302,
    83660,
    82973,
    46927,
    50994,
    75669,
    93198,
    63040,
    88017,
    85934,
    61221,
    34197,
    98843,
    42984,
    33387,
    96561,
    91974,
    29642,
    66503,
    52839,
    45836,
    12913,
    26079,
    77544,
    68347,
    87632,
    50438,
    52584,
    61632,
    98906,
    90893,
    10194,
    46785,
    51828,
    82148,
    77897,
    53368,
    18940,
    32696,
    71787,
    86247,
    56494,
    50696,
    43551,
    95395,
    64045,
    46544,
    86165,
    96117,
    98537,
    33444,
    54936,
    39368,
    82911,
    58265,
    95446,
    79820,
    89799,
    40876,
    42293,
    36637,
    19260,
    98277,
    62212,
    68970,
    43371,
    21067,
    75308,
    44869,
    49906,
    45217,
    50201,
    99156,
    20043,
    43242,
    47142,
    23278,
    78514,
    56171,
    27955,
    86709,
    96056,
    13890,
    82307,
    35357,
    34580,
    62727,
    21591,
    98258,
    74351,
    17843,
    23738,
    18389,
    65148,
    32995,
    51343,
    54522,
    90967,
    95431,
    57772,
    57712,
    52205,
    24262,
    47614,
    65408,
    50528,
    11005,
    10727,
    45279,
    92496,
    34096,
    12506,
    25503,
    39448,
    81314,
    66364,
    85889,
    39236,
    56055,
    90779,
    18166,
    53177,
    43673,
    36350,
    55270,
    65680,
    82812,
    50741,
    36155,
    14114,
    20019,
    84302,
    44026,
    34297,
    22061,
    71994,
    90335,
    39658,
    58540,
    34246,
    83116);
val right= mutableListOf<Int>(28882,
    23721,
    91527,
    13217,
    20832,
    82573,
    76537,
    67870,
    34696,
    18298,
    76275,
    84734,
    31692,
    47605,
    23721,
    36898,
    14581,
    63078,
    19390,
    28539,
    35451,
    61813,
    63691,
    50579,
    60331,
    13172,
    38715,
    87550,
    34297,
    72835,
    50079,
    63078,
    78927,
    70747,
    20439,
    98833,
    26663,
    85013,
    94866,
    91132,
    79638,
    75742,
    67646,
    99117,
    13172,
    21558,
    51254,
    50300,
    29228,
    80794,
    21014,
    91132,
    77537,
    39926,
    54388,
    87284,
    84795,
    42891,
    80777,
    20439,
    33848,
    41770,
    35843,
    45686,
    45195,
    63694,
    70485,
    30431,
    21558,
    90163,
    33804,
    11701,
    91132,
    22580,
    44508,
    21558,
    20439,
    50579,
    95053,
    46927,
    39502,
    34784,
    53745,
    34297,
    75669,
    87858,
    90163,
    18517,
    90031,
    74012,
    85675,
    46927,
    47605,
    10287,
    75669,
    36867,
    12161,
    76537,
    50079,
    25465,
    98681,
    75592,
    37738,
    41306,
    62821,
    52717,
    32212,
    85753,
    35300,
    39516,
    76251,
    63474,
    88451,
    26762,
    76537,
    84894,
    90163,
    90163,
    21377,
    69137,
    34297,
    51226,
    79980,
    76585,
    45447,
    19644,
    72524,
    75669,
    58221,
    77427,
    24390,
    60766,
    36400,
    98833,
    34297,
    86165,
    90967,
    20490,
    93340,
    18923,
    50079,
    17906,
    78371,
    39189,
    96758,
    25445,
    22989,
    20760,
    25649,
    76115,
    37738,
    73446,
    16805,
    36867,
    85758,
    43127,
    21570,
    77315,
    37738,
    63078,
    52739,
    63078,
    21741,
    54934,
    64622,
    59047,
    48025,
    69909,
    20439,
    13683,
    36003,
    76360,
    96966,
    14581,
    60518,
    52504,
    44922,
    15999,
    13900,
    76875,
    63078,
    49321,
    46430,
    44724,
    21014,
    47605,
    76689,
    61754,
    67964,
    55373,
    58152,
    83208,
    62998,
    50079,
    76537,
    20439,
    31055,
    58221,
    98833,
    50579,
    45945,
    64807,
    87840,
    96758,
    68844,
    23721,
    20439,
    34297,
    34696,
    33255,
    96596,
    51420,
    32699,
    98833,
    54523,
    78852,
    85797,
    49766,
    60104,
    65193,
    86165,
    37738,
    83353,
    21014,
    27405,
    44536,
    54522,
    66820,
    76644,
    61703,
    34696,
    17935,
    27541,
    62519,
    11295,
    69809,
    26663,
    50079,
    61107,
    50079,
    13172,
    47605,
    47605,
    37738,
    30666,
    13172,
    45822,
    24534,
    13172,
    14581,
    90163,
    54522,
    97135,
    66203,
    89376,
    54522,
    42310,
    58221,
    63410,
    12908,
    61813,
    83043,
    83934,
    92546,
    55163,
    37252,
    65193,
    80901,
    90163,
    57097,
    13172,
    83158,
    71264,
    36273,
    56793,
    95859,
    20640,
    15741,
    65193,
    96758,
    34297,
    91132,
    54436,
    63886,
    47605,
    20439,
    86010,
    51093,
    76537,
    33508,
    37738,
    34696,
    33440,
    38458,
    59114,
    42652,
    87983,
    75849,
    63535,
    90967,
    61999,
    54522,
    76199,
    54732,
    87542,
    49363,
    21014,
    78473,
    26663,
    65307,
    86165,
    65193,
    61813,
    18816,
    21014,
    93815,
    20439,
    34696,
    17725,
    61813,
    37284,
    50170,
    12991,
    40865,
    91132,
    60331,
    94892,
    46307,
    62129,
    35248,
    75669,
    80757,
    90967,
    79609,
    79192,
    20439,
    47605,
    64469,
    14581,
    66457,
    14867,
    21558,
    49569,
    36845,
    63236,
    37738,
    54936,
    94866,
    92731,
    36248,
    91369,
    91132,
    54882,
    26663,
    96758,
    82527,
    37738,
    72236,
    58221,
    29009,
    60755,
    45040,
    76537,
    72524,
    73194,
    44337,
    34696,
    98833,
    90163,
    90973,
    14581,
    60138,
    74800,
    13172,
    60215,
    63078,
    60331,
    31133,
    33467,
    86165,
    58673,
    12645,
    21014,
    94866,
    51324,
    76537,
    60331,
    94866,
    53459,
    45513,
    76537,
    34297,
    82475,
    72524,
    54936,
    15727,
    91132,
    54544,
    85847,
    15438,
    60331,
    63078,
    94866,
    50579,
    37007,
    12552,
    19339,
    10453,
    60331,
    90967,
    73382,
    42760,
    87519,
    91207,
    86165,
    61609,
    48739,
    50079,
    94850,
    18408,
    10938,
    20439,
    49950,
    98833,
    20778,
    53836,
    26663,
    87261,
    60138,
    94866,
    54522,
    34297,
    61813,
    75380,
    21014,
    76806,
    20049,
    17817,
    54522,
    24841,
    76537,
    60331,
    83825,
    37221,
    38461,
    58221,
    48482,
    50079,
    72467,
    60331,
    75669,
    47151,
    34297,
    61813,
    96758,
    86751,
    65761,
    60331,
    20439,
    14581,
    86165,
    54528,
    90166,
    72524,
    14581,
    34308,
    38899,
    93044,
    90163,
    52312,
    68941,
    34297,
    43658,
    77640,
    38466,
    16342,
    88031,
    22940,
    90967,
    53331,
    32163,
    23074,
    12994,
    14600,
    61813,
    98351,
    13172,
    96758,
    88939,
    20977,
    50079,
    76689,
    37822,
    45526,
    47983,
    54522,
    75669,
    91132,
    47773,
    34967,
    10047,
    19170,
    66307,
    21014,
    56988,
    60364,
    49783,
    33047,
    28530,
    30445,
    66503,
    69771,
    21830,
    36879,
    76537,
    26316,
    56614,
    36845,
    75073,
    14581,
    36375,
    20695,
    34297,
    86165,
    36867,
    63153,
    46927,
    60331,
    15850,
    76537,
    22864,
    25805,
    58221,
    55581,
    89723,
    25749,
    54936,
    21014,
    65193,
    86493,
    20005,
    96758,
    54522,
    76537,
    59570,
    34966,
    94850,
    90163,
    58221,
    21558,
    13439,
    34297,
    21014,
    80148,
    16045,
    67529,
    91132,
    47605,
    98833,
    77331,
    24668,
    90967,
    60331,
    47605,
    50579,
    16380,
    58221,
    76629,
    62015,
    81117,
    73269,
    50579,
    23721,
    94850,
    53461,
    50982,
    60331,
    23721,
    21014,
    26573,
    50079,
    58282,
    62978,
    78073,
    50079,
    50079,
    77847,
    23721,
    91132,
    43979,
    54936,
    35689,
    96758,
    52569,
    90163,
    90111,
    94850,
    13172,
    72097,
    72694,
    13273,
    68279,
    19658,
    50579,
    88469,
    72071,
    23721,
    13602,
    44961,
    28776,
    90163,
    50079,
    98833,
    90163,
    65193,
    50079,
    47605,
    94257,
    31585,
    81225,
    23721,
    56618,
    34983,
    98833,
    59924,
    17446,
    29922,
    63355,
    34297,
    22491,
    96093,
    45416,
    49990,
    12570,
    83481,
    25139,
    78735,
    65193,
    98833,
    86165,
    19553,
    98719,
    72138,
    78912,
    91456,
    71270,
    90208,
    92697,
    63037,
    90932,
    83722,
    26663,
    79977,
    31093,
    13172,
    88491,
    14581,
    14581,
    76537,
    18372,
    96108,
    34696,
    16854,
    14581,
    64574,
    76537,
    93370,
    58221,
    76537,
    56763,
    37738,
    50079,
    35239,
    80239,
    60331,
    87902,
    54522,
    58221,
    77272,
    24668,
    77956,
    34696,
    12753,
    88262,
    43676,
    93882,
    32918,
    23721,
    76689,
    50622,
    22895,
    34696,
    45677,
    20619,
    75828,
    90163,
    72225,
    76568,
    72524,
    34696,
    33221,
    90163,
    21014,
    50445,
    10606,
    21252,
    58229,
    89174,
    34297,
    72524,
    14117,
    11676,
    99098,
    67759,
    16991,
    76537,
    37738,
    98833,
    76689,
    96758,
    94850,
    23721,
    58221,
    58221,
    23721,
    75107,
    90199,
    72213,
    74680,
    91623,
    21620,
    98833,
    96758,
    34696,
    84822,
    41951,
    39439,
    76689,
    33261,
    34696,
    90967,
    26663,
    37784,
    94866,
    29795,
    22693,
    63078,
    76689,
    26262,
    91132,
    96758,
    27982,
    64233,
    60229,
    91132,
    77512,
    18000,
    42043,
    21014,
    21558,
    66393,
    36845,
    70406,
    63312,
    72348,
    84354,
    91132,
    13657,
    78148,
    18059,
    34696,
    12073,
    91132,
    11739,
    21014,
    91132,
    71791,
    18414,
    96758,
    90163,
    90163,
    23721,
    33634,
    80269,
    40536,
    60331,
    25047,
    13163,
    75209,
    23721,
    13149,
    27336,
    79877,
    86165,
    63113,
    50079,
    34696,
    36867,
    56006,
    40748,
    74418,
    58438,
    98833,
    34696,
    63078,
    13030,
    62867,
    98833,
    94866,
    90478,
    38157,
    32241,
    11808,
    47605,
    33743,
    50579,
    13172,
    20439,
    47605,
    71471,
    22813,
    27820,
    63903,
    24885,
    86165,
    34696,
    86165,
    22065,
    58293,
    22014,
    20439,
    11430,
    67038,
    50079,
    98833,
    81808,
    40847,
    99924,
    50453,
    86165,
    36668,
    39351,
    18607,
    94866,
    91292,
    34297,
    72524,
    91132,
    67674,
    47928,
    54350,
    56810,
    64557,
    67317,
    89274,
    61813,
    23721,
    40625,
    32386,
    21114,
    49990,
    48029,
    47605,
    59060,
    96471,
    42529,
    96758,
    16954,
    26663,
    49936,
    50579,
    45607,
    87664,
    35585,
    82166,
    91132,
    21398,
    65193,
    44772,
    95784,
    52263,
    88145,
    88929,
    60331,
    36867,
    64890,
    97599,
    37738,
    47605,
    24668,
    18767,
    21558,
    96758,
    94866,
    37738,
    98833,
    59455,
    54522,
    55930,
    26113,
    34297,
    58221,
    65193,
    26663,
    98833,
    54224,
    59770,
    64137,
    91132,
    22298,
    50579,
    99983,
    84250,
    58221,
    81144,
    20439,
    94866,
    98833,
    26663,
    97473,
    13172,
    62300,
    41226,
    87041,
    21558,
    26663,
    46978,
    53063,
    60331,
    63078,
    11923,
    34297,
    62082,
    27780,
    13172,
    20135,
    91048,
    92100,
    13172,
    83073,
    72524,
    26986,
    60522,
    28494,
    13172,
    41678,
    30862,
    76537,
    91132,
    91132,
    58221,
    58221,
    96758,
    55446,
    58221,
    31336,
    36845,
    26257,
    26663,
    93356,
    57920,
    76537,
    93956,
    60331,
    12543,
    60331,
    90163,
    21558,
    12711,
    42388,
    26663,
    11871,
    36845,
    54522,
    86165,
    14581,
    79223,
    26663,
    34297,
    72230,
    21014,
    81022,
    74055,
    96758,
    41704,
    87444,
    79868,
    91048,
    40755,
    37738,
    37412,
    68031,
    63388,
    89848,
    75669,
    63839,
    98833,
    26663,
    52806,
    82954);

fun day1Step1(){
    // val left = mutableListOf<Int>(3, 4, 2, 1, 3, 3);
    // val right= mutableListOf<Int>(4, 3, 5, 3, 9, 3);
    left.sort()
    right.sort()
    val index = left.foldIndexed(0) { index, acc, next ->
        //val x = right.elementAt(index)
        //val distance = abs(next - right.elementAt(index))
        //println("$index, $next - $x $distance => $acc ")
        acc + abs(next - right.elementAt(index))
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $index")
}


fun day1Step2() {
    val left = mutableListOf<Int>(3, 4, 2, 1, 3, 3);
    val right= mutableListOf<Int>(4, 3, 5, 3, 9, 3);
    left.sort()
    right.sort()
    val  rightM = right.groupBy{it -> it}
    
    val index = left.fold(0){ acc, value ->
        val rightNumber = rightM.get(value)?.count() ?: 0
        acc + (value * rightNumber)
	}
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $index")
}


fun readFileAsLinesUsingUseLines(fileName: String): List<List<Int>>
        = File(fileName).useLines {
            it.toList().map{
                line -> line
                    .split(" ")
                    .map{ value -> value.toInt() }
            }
        }

fun readTextFile(fileName: String): String
        = File(fileName).readText()


//day 2

fun isValid(reports: List<Int>): Boolean{
    val diff = mutableListOf<Int>()
    var previous = -1;
    for (index in reports.indices) {
        val level = reports[index]
        if (previous != -1)
            diff.add(level - previous)
        previous = level;
    }

    //print("$it ::")
    diff.sort();
    val increase =
        (diff.first() > 0 && diff.last() < 4) || (diff.first() > -4 && diff.last() < 0)
    val isDecreasingOrIncreasing = (diff.first() * diff.last()) >= 0
    //println("diff :: $increase $isDecreasingOrIncreasing")
    return increase && isDecreasingOrIncreasing
}


// 379
fun day021() {
    val data = readFileAsLinesUsingUseLines("./src/day2.txt");

    val safeCount = data.map {
        val diff = mutableListOf<Int>()
        var previous = -1;
        for (index in it.indices) {
            val level = it[index]
            if (previous != -1)
                diff.add(level - previous)
            previous = level;
        }

        diff
    }.count {
        //print("$it ::")
        it.sort();
        val increase =
            (it.first() > 0 && it.last() < 4) || (it.first() > -4 && it.last() < 0)
        val isDecreasingOrIncreasing = (it.first() * it.last()) >= 0
        //println("$it :: $increase $isDecreasingOrIncreasing")
        increase && isDecreasingOrIncreasing
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $safeCount")
}

// 430
fun day022() {
    val data = readFileAsLinesUsingUseLines("./src/day2.txt");
    val safeCount = data.map {
        val iterator = it.listIterator()
        var valid = isValid(it)
        while(iterator.hasNext() && !valid) {
            val truncatedList = it.toMutableList()
            truncatedList.removeAt(iterator.nextIndex())
            valid = isValid(truncatedList)
            iterator.next()
        }
        valid
    }.count { it }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $safeCount")
}

fun day031() {
    val input = readTextFile("src/day3.txt");
    val regex =  """mul\((?<left>\d*),(\d*)\)""".toRegex().findAll(input)

    val res = regex.fold (0, { acc, next ->
        val (_, left, right) = next.groupValues;
        acc + (left.toInt()*right.toInt());
    })
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $res")
}