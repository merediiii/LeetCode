package 并查集;

/**
 * 839. 相似字符串组
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 * <p>
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 * <p>
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 * <p>
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：strs = ["omv","ovm"]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 1000
 * sum(strs[i].length) <= 2 * 104
 * strs[i] 只包含小写字母。
 * strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
 * <p>
 * <p>
 * 备注：
 * <p>
 * 字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
 */
public class numSimilarGroups {
    public static int n = 100;
    public static int[] dsu = new int[100];
    public static int[] rnk = new int[100];
    public static int scount;

    public static void init(int n) {
        scount = n;
        for (int i = 0; i < n; i++) {
            dsu[i] = i;
            rnk[i] = 1;
        }
    }

    public static int find(int x) {
        return x == dsu[x] ? x : (dsu[x] = find(dsu[x]));
    }

    static void merge(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x == y)
            return;
        if (rnk[x] <= rnk[y])
            dsu[x] = y;
        else
            dsu[y] = x;
        if (rnk[x] == rnk[y] && x != y)
            scount--;
    }

    static boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public static boolean comp(String str1, String str2) {
        int z = 2;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                z--;
            System.out.println(z);
            if (z == -1)
                return false;
        }
        return true;
    }

    public static int f(String[] strs) {

        int len = strs[0].length();
        init(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                System.out.println(strs[i] + "\t" + strs[j] + "\t" + comp(strs[i], strs[j]));
                if (comp(strs[i], strs[j]))
                    merge(i, j);
            }
        }
        return scount;
    }

    public static void main(String[] args) {
        String[] str = {"fetezeqwgnmhbeifkwmqwozkglwijfmzihvetinzpletocdfmcaybfulpvzkkdchvinbblxkcyvfttsskonklmkiuze", "lzfzlzecfsmkygtviaekieygvwklffihcoqbnkevmudmotecnpuidbhqzcpstemxkkzkitltbkfwzionwhnlbwjvefm", "zblvvlvnunzkkkwwkpohlehiieoelzccdyesttfzuiqxizftewftgmgykkfqambdtiebfscepjwnnivboflmkmhkcmz", "mnpbwekmwklbfdfuvelufytvtgtmcisztobzognezinldkvhfbqnxykiwcivcplelkzhmfiaejeziwhzqkemskkcfot", "fcpbmwehidzfmzfydeoizmpkacecgsnelyfbelvbwhkffovijitnqhkvsullbnokintmzzktlxttkckgwqeezukviwm", "fbwgklhmcttnqvtiskzebdmpnmzbnkghkofkoliiftkwleatlczzypifkcufowmdnseiewfbzxkjlevcmeyezvqihuv", "wqgculiphzbknfmslfqeztncdbmkijeelfylwaiebyktmtfcdmgxkbwskheleiuwfvmtnkoezzikkvovhtozzpcfvni", "bhlyihxnowcezwtznlkkgiovgbitefnmmtvfvlikzqcjibuezkolzzdfhmufnfeebfpscpkkwqawkvydsietmmekctl", "ummfkvkfsekfkctbnwnnfmoysimqelkihvpthtleomnaizkizbvubewiklvokgzfpcbwqdeectjhixyctzzfglewzdl", "wwzhlktxtjfvozidcvynmbmaiolfktizwffchvduuwgeitninezmkhoeslpezkpkeikbkkvegnmlzcbbeqcymtfqslf", "ycecenihzkpkobkmmmxigttqmftikfkwfdwohetdlenbabsckbqjcuglwznozteefwulskyilvpmizvehzizfkfvlnv", "idkcojeklbgcbzieithnktkskpazlhimzuzxwzeiuwmvqccknzdwlbffofneehknqykfeviegtopytvblmmfvfmlswt", "kzgehzemtmtwwnqiotivlvtnsflnipkkyxcnvzdzfbmkciselfblymfdkmqcfajkiogehczzekwfhblivoukupwbeet", "bwoqgzefhiptxklztwsibklevfafymbompolfezvlhncjibwicmtfnkekvdzcmwkgeckesyinkinzltfhmukdeuqztv", "kowhbktikotstnumgjiptwzdnfbefistzccevvpycalkmyzmnoibeghnkfxiqeeiwvuemmffzckdkbllwhfzlzkeqlv", "mzhcfkwieffomygltkldlswlzfijutksfpinezeevezmokpcfkwtzimwkcoznvvbdhnamklceetqkiiyguxbbvbnqth", "fhcfwizkzgcgtpvyesfvltkikilkucapzhetojebmhxkezodowbtzkqnsecknvnlfvbwwlizedmfminikulqtmbefmy", "zvplqwwicexkoifkmebzzthectvvlymuitekwbvtkmnqgkeipfinihwjtznoubflhcnlcedoazskzeffydmskkmbglf", "kizofkcvykftekzzimfgfmveiqknemvnubaxmywhvlgsljtctizfkiheeewenqphbkbipzllboumkcztwdsctowdlnf", "vdvsqbzfkimkwxfyafykilkzqfbelufzbkfkienknutvejndzhewscpictpiogzlveotmcwithntzlmkcolmeemgbhw", "jksildztdtphivsqzlwoblbhywuofekgkeqhglfckiffetzvkmonmmzzwitwmkkecuytnliicbxepfvmenvzbafcnek", "ilbomftbefezbpwilezhenifetliywzvoohvqfnymuulvmdkcizxttkkkcskcisdfhlkvpgbkkqncmgnfawjemzzwet", "kkdghfphbbtbnfklekgvycsvhimfwiuezswczkmzudfcwtlmfoizlvaeqiipxmwtkztzjklqeeeomleybtifoncnvkn", "kknhgvkeieavphmytfmclkvqkkwmzciwzqoufzbglzfiejidkzvtonteeeikdcbnllpobcyxwwhssimmnfflzbueftt", "mcbtzkvmkiqxsbzejtwilksoovwkhffheccqtnnffzdmewfwlyvliedlpkiylmeakmpinoektihcugebtkzvzngzbuf", "elihinpviwxuphbmfegwlwzteevjankllcytkdoozudeviftcnftbciichkktezkkmbffkfszlsmkwgqbmvynzezomq", "joivdwpcskzkfafgqzlwbuomseqnetnhlmtfwmhvxteifncuezlzktkmleilefckmziicnfbdyybvkghktkbioewvpz", "kmeimkflpufepotkzdzlefkbcefjllqttzcmfmqohbwzviyecnkdlaswkiefxikghewhtwtkbnznyzcbnivguvovsmi", "zlgfpnbomojmcfzavflwlkudbityzdkeynnsighleqwpwwqflhvcikfceicsxzozmeehkeztkbftiknvumikktmtbve", "bmccwlzechslnbzieklmvkywikffaekifthzlzkqwkvncoieeyfihwntkkofpvntvestuzmmmbbqdzgpxodujlegitf", "wczuezkhhqmnzkntmneefmyeoxvucwyfwlvsllonsjiifkctbkvpfgfkbddemitzbebifpazoihilvlckgzwkketmqt", "qlfdvsyicznwbggliwofusnaeejzmwmkffvkbpefdikeohmtzomtnzqktyefclikztmhexkticbvivuhlknzkcwlbpe", "vifpwlmzdevzhqnaebloztcckotlbzcfkwkseqitubjyhcimuofsygkflzkndfvmgletzeinpivkkmixwhntefkebmw", "fvzqnycdqmcwlzobhvmiovtnxkeehwsttgeeciyijedbibkemnmalubugkztksffllzizlfniwzkpophkmktwckffev", "lbkublskmtysfewweyhmkkdzfifnkfcclzuztihvlmgievekobetzveatwcicnpwfqkhdjevgibmmnkpzlfzxtniqoo", "yfueieeizumdwfhttmizkookxmltfnkcmmoibnfvwpfzqldnvqetechzyenhzvksvkikgbwkgbcfckjiaeltlbwzpls", "fnucnnbelwfikeeimtqhtvlpkgkvcwbkfchiyzqvoetsfbmitezsztejodmouylizikkllfmkxhmfwnpwcgkzzavebd", "hzifpgkjklitnkkvgiqfloyolacmsznvqmswbevhfekznetwldmmxtzbkbtvfcyptkfceiinkciewluhdezwmozfbeu", "flwuvshfelizcbbpeecpyjftzlczfiewedmotmstnxcznzwkwvqahfiizkkegmlvobihvlkokuybktqmnifkmdketng", "nzcszxpiloekiqntbbkfhvuctttinolbfefohiksvzegcnlfzyifzwpbfktuyihqgwmzdlceawjmwmkmdlevekmekvk", "mojzczvfumkiokeiliwzoenwfgkyhmlmzuitzfknlnbihkclweetehdqcmvbzkkqbeevgxlkfbstynspwcvidtpfatf", "fzfawwztibgsmikqbiepedyfpzvvzmlniikcevwkoijmtkmqglfeldkkkecctetlobxbhmsnofuuhkelythzfvnnzcw", "fmhngvkwdvumlqlbcfzmsqieinmkavziobpvtfczefmkeihytotfzknwflhlnetjkzkewxdcpecitywokbuszblgkie", "oahqbbcuvzpsunetpikgmliklzkftwzblqfnzfijkdmilovwhzcmenkdtfowcfefgmzsvtweemcihyeytbkkinvxkle", "ipmedzbymwwhczlifskottignhfkbvoiaktxjzbmeptfinwcsofelkdylefeqkkhmnlwleztkunzvmqvikubcegzcvf", "tcwzwnzelzcenmmkvfdkuohkvaigqmtsiewfkdyvsfnfylhonhkbikzewmetcxbtijotbizfclleqeimkuplgzkfpvb", "gfyuvhizesavnitqifckdeyejimkzkklwwwnwvqsofbuictbftthklfmomzxkpktczekezbzbgdmeemhvlocflnlpin", "cmklzlflzzzeaitmkgmpqjcychotebhkmoevsdpenumkikuibbwbnsfkdnfvylqefleiknwgteiczvtwwfkvthfzxoi", "qvnvieifjfyzftvbktmzmsboztkfuelkeodlhhfglwihnxcesfelivimbczyklcmmtnkbwwkcuoeipnktkzgpaeqdwz", "idfvzktfksebcikzbhhyeavizwjdieqolmteqffknnclwiztgckyfemwlumpzhntckvuxfbltlwmvokgoekimnsbezp", "ikwhmdzoikzambvkheyikzfmswffldvgpoycuucewnmlhekvngilcekzevltbtjenitskxtfiobpzqkfzbtecfwnmql", "livnznkyaknicevmkmoilefhzvtxlmdkikgotsukmzctefvqlwfqiwwogezpebhkuhiftlydcbfkscwjztfbzpeebmn", "ekugmsjeeomfqckbbmgwkztttlpvkcfzslxkzpvwifieoukolfmblkdfniiqhcfzmknewctliiyzntwnzhvvdahbeey", "fzigkkzmnuvdiwtvkcsedablxicbtvpmlnmnfkiezykvfeonlwfwftyuckeqlsebzokztihelhegwobihmjcpqftzkm", "ilmfudeblqfkbejoiihfmekcvizwyzyztwkzwpcvnetaihwfsmskfkzzidbxnkckbtcmgglvluenmpeefootvtnqhlk", "beuoqvweieknkmlznimzezagivdnkbpgfwklkmniwkhfhmoftyhszefvfeuzclotlezwmxdktbiqjflyvtpccktcsib", "cbekbkfextlqtkswnfzezpgiotmbkewkcinnieloetvkuqalmfecuykmvmlfvhsdcwtviidmzfgwhkhzzbyozfnlipj", "kqzbnboecikiysutugmzevkhcksqittfynwbfhlezdptmcleevmklgbzendpmkzwztfkmvolilcifeovfhxknfwajiw", "lwvbezchekieulkvhycbpzkbqkggivftnaibeufenmosmkdvofwtdnflfiezmyqimtknkhzmkzcsloixwtlwztpjecf", "bggsitzdjmeoefoyzkeenfwmfiimmhxwzwfnvtcplzlvnunotuktekzlihbkkffmvqdkckbelcehpiblsiwytqvcazk", "zkmhkhjezlfzveksfilmdukoiitcmkqwwbqokppztvlynlsevnbltfxczfeytizfmutkembcehncvgbgnwkodewfiia", "wzweimevonfctmhnytlknkwcmzlptymieuqpvedocmvithifiufdbfleakfxzzosklcetgkklhskgzzfbbijkwevqbn", "kdaeqvmslufgzbzwbfxmtwniqkkvulzefckmtcojhbltmfwimffnkphyieizdlehlpbnkyiovitetwsvekzzcncokeg", "lqvtbxfwveechkgmpznmpemtebzktmlifkfkfjbbzgnizfswylleiwlkvitonvhkccuidkqdtsyfwemcenzioauokhz", "kietpdkzwlzhwnelwhmsobcvgulvmsynbvnktaimekffbcgczipwlbkiekztkxkzfinehjoviemdeuztfqcmfqlytfo", "fcgilnmtlmxwiqevmifzendcfgdihefzwkqckkwbujbtzyscfpmttkflzeklhobhzsmyiekbuovvvwieelknnoatpzk", "gltotqbmzlczfsezcxhhntmkjcafcenuhtknkeikzbfwiiyvzuyefzvksewbildmiwomotipdwbmfneekvfklvlgqpk", "fehobcletefagmtwosiehvzvtzwcqblkxikktdmiinzjtfveygmlipekbvnkwmpzbkflqzmdyluffhzcoinskekcnwu", "iiyvneckivlfjleiztdgcfkzugtwebiknuowkwfabkzqeyolnxnmwfcbcefhtemhmzqdlssmvpfivpzkholtkmzebkt", "cignwpmpqosdniltlewjxvzhwffoztnetfekhatmmsbnikyiqikkevckvtefvkmbwhulbzzzldukkyzmbfoccilgfee", "wkfqjkkelizeuecmitebdhbegadnifvlbnclfiwpktehvkzbyuwzgfwtoimznxzelcmmsymkiztlftkvcksofvnhpoq", "pgefkieikqwtykvtbcmcislbwefdgzuuzezihhqionklyvvkmmezlfmzfvbhkttnclsckxjfomikltenfwopdzbnwae", "ciituwumtskklleatzbepeozcoczmgnbmttqkegefcoxfkemnvnielkfliqivnyvfdswkhlidhhkjmyfbzpwzbfwvzk", "ikzkvpvwcobmcmqwtimetnlgkihzjxtntsmoycfkgwbwdfafkuilielneflykeibnzokzszlzhbhfevfmucqedevtkp", "jnmwkbloyomluekectqchuzggiisftsnwvektpelckbzikvenldwwxofcemlfkenfbvmzqfziikzzfiyaphtktdvmhb", "imbmfkylzftfwxfnhpdimgqvopelkaowlkdzuokiwylkefzhtgkctevnshtzkbcwvzbzqniejktemcscmeinuelibvf", "hnwufndvmckuiigvitwpfiethfecxbogztecetnlqmeyvizvdkepbokwsmmyqllzlznwmkikhzklkztfocebfjaksfb", "yoszizwekqhkeznomuztnwjvnabyhockfitmcpmkegmfwzlnibfpfkevkimxgiczqulklftlktbefetdisvldwbcveh", "nikzkwqxfikofvnozilebsdwueukbtkjvtbfeifhcestmlivbfdenmclmcgckaylnetvkzegwipwqkylmzhzfzmotph", "yxaizlkpkqetdltfbmkvivqvznghsfnhsklfuojeowvcwmbpeleknzkiilmeezdtmcycfewbwitchotuzfzbikgnfmk", "ilztvkvmatmheocewnlmitefctkgwjgvkffzdbqlepltudeqkfckoklysnnixzzsvhbciwoniuzhmbykzewmbefifpk", "vhfneihcxtljwkosffevnbeskigzakoezbpohelgwittmmfzubddfmepknvmfltiezkncucbzityywvkkzlqwqkmilc", "lvikofpkgnzegcfmikevktlmvizatlvnenhhdxhsbqtcmkkfoywuzbkojwqtpeznztblzwfyiwcmlbeiiduffcseekm", "kllkmffinzlhqcvkovpilbeozkwzmxcqhtbmdkteyvgiecpfzbsuyftzbwjseiefuaitknhowntzvenwkcflmmdikeg", "gzezzmmztyselniqoeblzfelkvhzuffbiwmfwhnwnikkemjketlccqpeivtiygblktcpfkbmwocsfxhaikdkvtvnoud", "oeponltwffwbhxkliplzunkibkvemykzztmhbhlavkwiozczwiffvleevsdijntnekzteycmckmgdfqqigfbektucms", "lckyzndvbtjwpnenfsouztmewohpixvsfeeeliglcfblibkdftgfiqtokankkcimlqmvzmmzkehzhkvicketufbwyzw", "ucnxsnwtqkeeilezsnibfzzmgfkbwhmomzyifmzbqotjflleulwktvwiegkzcfkkchiaicmpytbvehpnvoklkddetvf", "eofezctgsevgfjiblftkdkynhkiowqvotqwzlkkwievneceahzuslziminlkdittucbfxmblvfchfbmkwmepzpzmynk", "mpietqlloslkbpxvzdvfnnvfushzmtiwikehvtogmkiofmfbwectfztuehzeijlkqecgkiyzbdlwmnkcckkzbewnfay", "omlkltybkqkbitzzksefbimkkfcxibimcnftgoselnylffctwedmeeeavnmkvlwinzwczzvtvkzuhpeifwuopdhgqjh", "bcftyuiiqdikniwtesnpkcymlmabwfqvjvflhkvtfnhewobgfptezkeeezlczvlukxhbkizcngzizdlmkmoftkoemsw", "nbfikykivwetdhwmwmbtizktnfbqsniclmfqcklzoetllzwxfmcypzukkaglhemkfuzenghfeiobeipjvvevckzsdto", "ntewzjzzfdmfitoqsnggoepcbbkomphkhyxevsvnzbeieikfkluvvekkzzikewalltliwdcffhcyqimmcunwkftlbtm", "fedekumaiwqssvhnhvejlmgqofiztkklgfpnclbitkztweezftwdteinookefklvicylcmmzybnbpcuhifmzxbkvwkz", "mimvpdniebnkonmezkzuoievsuytdzgsvfltinlkwwvkjmfeibffzeqemflkptwywtfzccibktzgxclkhhebcaohkql", "ltzkmimvekzpdhoehlknwwbhkvcgcefilcttbefkoqfkmmybksfqwmeanepzdivlsubzeclvwtziiftjknuxgzniyfo", "mjctfpzmlkzqkfwtzhclyobptvoykwtknmhikmnfflfvwzwdgblgeikbhuimkbeivslveetceenkuaqdixcnzseofiz", "wfodemfeeiegaheecmyzclkpsbsodkwzlchxklkfhvnlfqfquzpinztciibtgtzkuwvkiymtwikbjnnevzlbtmomfvk", "iibnczflloesztzeiqmhhewnntcdxzkvknpewtzwliakbopytuzvdtkqmwmuykkelgghbijcobscefkkvfflfvfmemi", "fiecfimnpisukglkbkteeketkazifoqlcxmykunkoztndmfvfhtmhlviicqhkblswnwbeocelvwgjzfzvwbpdzyemzt", "ftwokvmqwwvntniceskthkmyzfemvqsfapcjeitgpeetfudkodmykfilbkzlbugwinbxklbhzifloinmelezckvzzhc", "bhbzstueahlnzfvfwmekctvwkiwximkfptwncljzzckknilhqoozdifvecmpbyefintefmeikgmluktglkvdyzbesqo", "wbuhkfznkbftkkkjszituhqmescxefvhebqnczvzypflnodpwelgtdftbnkzmvmagloleiifikctkiwvwceemoyziml", "vmelvozubfiilwbfestydnlvzclokwwngnpethifkkieclqoztumskdmifmctbmkgwzikezxphctvbknekjfazeqfhy", "mwzkzcihzxiwielvmdfeuktgvchmqkniwydftkcblolnfhkjeetfpvmogtueveatbwikkybfqmsiplofnnzcsezlzkb", "ypziilfvkelvslhwehwtkpvndkqgltekkfmntzcnkivohdgecozsqifmelazkumzymtzowitfbjcxwmbunfceiebbfk", "fnailptsckebfuvltbnpkkjxmhiekvmtcotwzizyckmylfetfwzgsdehfozklvdqwwhbgenkiqlbmizoiuznvfekmce", "quvpokmtvbzkwzaciniwfwzelmigebqjkokebswtfimdknitvxhozcvmylkngeeultnkhdmfcefhefzcpltzyifsklb", "dcjvehemxfbpktlpwlzioqebfknfunctbwcyilcotyizkkehoaswkzfvtmftkqlimmmnizszwdlvefgvgezbkkheuni", "ywxspnzmvkcbbqymieghukeifmikifzkbkhiovdebmmhzwskznwdttetccvqflnlpvlekffocntalzugfwejetklioz", "nzedimbayiwldttmfzpezfmekftnkeizitiwckpshvlbfgmhwnokeflqnviykucjmbkqolfklkoczghzxcwuvsveetb", "oeoczmwkdtbevpzitgtmffefjqkhiwckbuvknltdykicifbhqnmsleeboexmpitkefnkgwnywfazmulzcvvhkllizsz", "efzhkinvjkxtsvzdccmzpizmlfmtkhtigvoneenklwmkeylcefzlawitbbszebhomqliufovfdkctbunpkkiwfgeqwy", "cqvibqmtkkxidwkgnhvpetflzjzmtikoenwshlmhvylfgsvebezkuebkkcbzfdttepaffznfiocwmwniilzclukoyem", "eedkpqttmslipumwzmoofgbkcbvlbiqolwetmlzykzhfwjcekltfuffhknviizcmcksennvgaikytedhxznwefibvkz", "xhzmcpwmllmfeeviczotkkgzhekntepmejelzvltuofovdnkfyfmfikfstsczdwhgknnkeybuwiblbtizaibcqwqikv", "cbomgeslpxjiketfdtkwcbekzyevfaumifokvivzhmwllbznzotiwklenflmqcyfwktibqezcvnneifzkgdsuhhptmk", "eenbikvmmiwciimhqspqvhlgfyoselbihotfzlelkgkktedbeiazfpuwzjkzcmnftkvwcyvmzkctlwnftuzfneoxbdk", "howmnuwcbfzeevwlepkenwllvfmoiibtkzhmkcyeayielcvntmmfzsiizkfdivgtpcnsoqkltdbukqfebgxfthzkzkj", "uvnilkmvbzcdtemnzocgslmmfnaswqoiikezxjtbkvntblewofhydvkktizwfulzphfemhkeeyfqwicltkcgpebizkf", "bfmdmbekkultvpvleiwowkeofnxintsdgthfzcsowamfknchyitwefmllfkvbzeukiizyzqtqjcelvenkzmiphbzkgc", "luwfbiofnltkthobzinikpmwlvzbskqcydxghmfineotkysfewbvcketcizfejmzkpuelqvkfnmlweemkidzghvzcta", "kuenzcilsqwegqemvpzctjiditiwflkfnecmxvlkotgwkizbftkzdvvykpemehlmuknoffbbmtaeofzycishwhnbklz", "kbfxlpzjtmlmmhqynfmltdpzzlvdbnncqhefwmaiusvclkkefkzwhoetvzkkisieiutfwvgekiccnotbgfbyoweezik", "feiesifwkivnpxjgmceumkwihvyaetnnvzzfdhpfkqzclfoncebvikdbzmysktzotzlqlkghiefmetomktwclbblwku", "hfbeoapiibiyendztvidkexlkmqnbwmzkokelzuenkbzmfcjpfvhfhzefggwcwctlszmvttkivelotlnksyumkcifqw", "ikmjivhhowkvewcklnbvtfbespkmfefgellkxtfnkvibowluycewztfeyncfiubkzmdqaecmpdhtgzmkziizlztsqon", "gkbisevoitqgfazqhlxyfmnfklzvlcywtbwlovdcouetizefzcimuthbmkvfwecifkkkmwnndbphnztipzsekjkleem", "wimtenyffvjitbkwfykiliulztzdsqcemocpakzegviptxzbzwnmclonohqflkbhzdvecithmwvgmfnkkekeeukfbsl", "zwkkktndkovoglmkuifeispfhwxnglkviwtkzwlcdnbfquonfzeaejlhvvfkcpqyihycezlbtfttezebzemismicmbm", "gghocvtlewpqjmivzkiemundltiklafzmeffbtekcydwwtfnfosltkhkyunmzkxpevscqfknvzbbezkiiicbwlhezmo", "zkqktkfcbnivqvdwxeoinelhjcdmshzukeoemluefgzwkmpieltiyicfttvnkwgblfnfmbpbaizvseokmzfhktwlzyc", "ztxabiohzipicinhvdmbmyufcovkzlemmfllkjgvtcitengsktsuzetkwpcfhdifwlkvbmneqebwzoqeyklzkfnekfw", "lqozfdkbattknzwjfmbqheivgbcmlckigbnuosxzyccefnihkpkekvhfvzdteptketmfylszvwwzlwikfniuieeomlm", "iygntdelgmhmzvluookejwvbiuazfdfhnlcfypiesicfzkctzftkkivtmkqbzweemctnphfbmiwonklwsqzblxkekev", "zzcwmkvifioftwuhfhwbeilvnfvycikecdzgmqgbnuwqcsfhemblpkatkmljyzktiteolitekvfbnzzkldmknopseex", "kmulhmemzkplfxaobkfhlybeistzhplmntgvlkztyqcmecvnvtefifnuibcbczzeodvfqowiewjdtizgwwskkfieknk", "oipfkzbkhjfgcizatpimtshldowgvfeqcmyczftfetlqvevkzeecwhmenxsbvmnfktiildmkkweioubzlwnyunlbkkz", "iltkztbmxhtfubdiwwbikjztbhfkfnuvyomwceqnglnkefqcnzimvoiklhweadyskskovleifzgceftpzlkevpmczem", "npbmclkwklznkvtdfescugilwofistekezzminzehvgkwmiqlkbtvcfvdeeylzftbhwueinpqhzmfckjaokmftxbioy", "wkhbfmboonkyzeklehiydwczaseekfntpwnqspfkoucctmvbgqxelzlfgizkvmfillemkivhtftnedtizzbvkwiumjc", "puytihkcwlkispeozofftulxczqknmnfdhhzivekfyweeovewfmamkcnlfsgtwkzzeidcmbteltlivkvkmgbjbqbzin", "dlfhkexbnvmjzqizfekltihzfkhzttplyefiykviwuetcowiltfzmecvmblonviqozcnmckkgmbgukwdkfasnpesebw", "tunfflmnwfckhckikegzkvnbqklknisldzkohsabfevtvwhcuipezzkeicdyqioetimemgzezolvxmftwbbjlwftypm", "tumenzylfwlwkkklitvcnbdzizkmbqfoitkoqfhuylejkvbsmvcgfzknfdeksiipzmpwhefcztwxhamngeibeectovl", "jvfgzwefnlceakctuldsfkboetuixvtmhbzngeoehkfzetqmnihyisfckelwwiktpifpmwmbzkzzdnmcvlkbiykqlvo", "wnhjyozhcedbtkumnkwzveevzcmlopyflexmsmtbftiniopkzzulvihbemedqzkwflgtfnkfcfteivbwlkigakiqcsk", "znkcihihkijcatdzeyiuqnmvitqewvfwkwplftyczssblmlkzbkzmeibeofhenovcemtdbtkpnkfuzlofxewgvfmlgk", "fgtpmmsclnllczlbpgdybetzowavinwswheewvvckzbqkikqfemyhckeifmfvkxojnluozidkmkizftnetuikhtfbez", "impgmtdfskkqmiuhimnvzeiljvglwnwkkakeoizoztckntyzthfufimqzpbefzkvftbwbsncwbleokefcldyexhlvce", "lwmnkqhzueltfcntlgiwwhaxyekfisfnbpedfbtofleizekozvzmvecoskjwklhvizutvcfkkqbenbdikcitmpmmzgy", "ybtvjciogmccwvouivkshyqfkmnfzslktnzmikemhtkwzlwpnibihalclouzqfkefetlzkepffdziedvbbgewxknemt", "vnupjlvtgznlvifuchwxtieiyqfbtpbwfeoyizklhcawczftzgkekmkviknekefsztzobcmmmdihklqkmdefbswlone", "sehkwckzetkvfzenpwwteoizleyudmpultkblckkffylftjncizevisibeqlkvngnofmvdhzzbgmimhobtfqxwicmak", "vylgklknmfftmfwjzxihqzczeomwmudztotyzweefsuvcvaktkzbhcfskknolmptciqbeiwlhbpingfbndeekievlik", "bfwbkhzegsotcvdqvpmlwmmitbtkisyndelmczotljfikmivnfyheiecffeexufknwclzgnkpizwauhzztklkvekbqo", "wzmkobthsolgkiliefkitlebwfpxwnylzqfzemynekzvukvpkneccdgfmfbeimwefvinkcoztahkcsdzhmtliubqvtj", "itbqmcbejfnzafdhmtzponfhzgmwldxkzivbzgsillcobyokkluleeekitekvvwkwhmnqftwivmskfcpieykczfnuet", "unpklcikqwkoveylfttvehimdisfzievzxjlfzdumcovelynwfezikknsmggclbiwfebttzmfpboakqzkmcetkbhhwn", "ouzyqhoffmzclbiemgifqelnmukvkmkgakhdyctnltwzvszppzftklztkwcidonekwecjtfkevefmexbiinlswbvbih", "gsletnfklnufmktkhebbpznzpsbemoflwaluinybfjwvickihizfteyokcikmvcoztmdzeckwlmdhtzkqgwvviqexef", "yblvfiaikkmeetcftlnnhcgzzwwpkxfvkistkhdzqltbzofpubtewemvkenvbmmouczqyeofkkfwhgsneiijmidcllz", "zkdosqkmhckondlkzymgobvcfeiwjefevzpvuwtnikyhtztvllkilgwfxpnwqsmfhiautebebmezfmbktciecinkflz", "eidecehlvvowcjbeznfbgomemihoktsvktkfvwlmigkqwaefmznynkzuuflqtpcipetctzhdxisbnbwkflzfmkzkily", "bmzenfilfvknolehvqmmioomyhkwbknfudlkkiufilxzbzztczmcgfcjlbintvdkqvthtssekpgezwwitcwkeeyeafp", "wfwfzakcuebfmylzmllvfliitnsfhkvxzwkhteioetpnlbcdpezftmbhievudsowqembvticniqnzeykmcjkkgokgkz", "ptkczkjsmvkelkqifzbneowcaikcwdhlelqstnflzgmhwumvwiiyfmfhpttkvleoovmdfgbkbiyzeezezbitnufkncx", "thzultopincdnkgfmlxawyknkkzlibjzwlfoizcenbehmvqqpcbkfkitfwheetoivysimszkkgfeztelwfevbumvdcm", "evkyztileeetqewcffwvnfujslytvdbikmmonftzvcwlioekmafzgszldiznpzkpbkcltmbmhwnbhfhuikkceigoxqk", "fztloziwivxzbdeiffkemlkbcntiflccskbtkvzlvsfhtvkzummadtwgghnkommbqcfeeeqywuekikhnznilwoyjepp", "tvkmttktvnhwmmdtfzewgieksepyigswiffbvbxbiklemnimjaclzoziklfcdkwozlfeculebqnckuepfyqhokvznzh", "mbfzmjlziknyzbufqkceksmlewtiqxbpczayltvmiihevbznhoikfkgteomfdzlueenikktcfwkdlpvtswwvhfngeco", "twmegheamevvnifkukbtwcefmutiwkkilklzdhokopcfcvtzygelzkidfeffvpklszniqzbnzblejnosmbhqxwcitym", "fesqdebobhivfnlibcpexbvefkkzwmohiifqgtkltuzkymtzntnvtwlelcnkfiepahmmowuszkjkyevdzzfmgckilcw", "zftztiectdkgihwkooyvkkfkwbmacpefbkwllhpmbicczvkzfdsxillntnmtvgjsiqzmbeeemnznyhuffeiqelwukov", "wpvmtkmzfndhnkfkigexkqibcevlikuekpjtwnlfuzyibmobgsfbzltcfmqcliewzncohlmkkzhzafweteseviytdov", "wmlqcdybtvkjwpknotkwvzfeuconzcffaibmbhdgitfmhfivklevinmellxkeeqtkshbtezifiknmgywecslzzopukz", "mtjnwecyuetzntpcfklkeshhlbivzfewifefuvagbkivszbbhkeowtytwmmqfqxidinelgvclzkkzczmioklonfpdmk", "zjvkmmqsaniktfvlkkyenuhhcemfxmkbvwbwhetfiiuobwzziqfdgzkvgeflztwcnzpytlemfkobionkcesceidltlp", "wibpmftevznnbnkzbhocmiczfzgazkfvnfhlllkiqxdoloisjtettumecqemklidekfgpehuvywktczbkkfwevsmiwy", "vpecbvvnshfzgluzhikliutebmkbmkzkbowoenecyiezfmkzxjmkotwypfzvddqnclfthfeiekqilgtnlskwiatcwfm", "dckbktzgnqhhezbkchvvwizwmepmzfllkwgyeewecloozxqjfkcktnizifstofitfvfedsimknuibalmntkbuvlpeym", "kewwlbmfoytlecveiiqidzikebksgmlzknnetfycszgtnvvfwbcoonexkelzmmlzqihthwzmjkidffhkppuubvcatkf", "bimianeehioztbzwdxsnfevoezlksnkctllzphkpcenbfhmikyjqmwgyfdgzoututvfftwkqkfvllwekivbzmkccime", "ckeimztpifsqkmukzfkvfvkeyucnjcwiiemtobqonevwgtwbdtlblcnfizwxlihzzgahtkdvkflbmpenoeshyfekmlz", "nzbbkwlmqgofmcfclziwnmfesioeiqhwfvekxbfhptgslukiemyvucdjhozlzewypfecekltidnkkativvtkzktnzmb", "zvlpkgzflbvtgkfozcwkiiomeelqfydwbblkznxekkbjmamlmkuieznqhfshdwttkpcwfvyztceinfhsenievtuimoc", "nevciamitwtvfftpjuzugzkloyvzwzovkflpecyitzednwkqccnhofktlifzmibkksieeklmxgbmhldwhskbfnemebq", "dkeobkyhkhewvkntktbsmezuecieoibwclvxiaipoummfqzvmiepnsgvnlewglnztmbhftzficzjyfwkkdltfqlkzfc", "iucvlopglbfznwlzemkiikntenqnksbkkzgehqofivpdzofhiwfcabzzysetybdwevletwfmhlmtecvtcmujkkfixkm", "liimogkqzfzkmecsbzzetixtlufmviulwendtkkypzfwcweblwovetzvoftkmdsfagbfiknnheiejlknchyqphmcvkb", "fwgnffjhxvzkefwgtkltlpelcocndhizskvtwvmtkeklieoucqanepzbizkzukeimlfbevikyqmibmdsycwtomfzbhn", "pzcivnydfnzgtqmvnzbbiejpetqeokkvifmdzkeeehoffzfklewnzshylmxikolwlahcbkgkmbcvckiwwftmuitltus", "omlbilnngkecnhcofffcvuwkpkamzfpxmivbehikytcwlbufwqzzljvobkwesvkytekmedsdfzhzizimikqnleetttg", "azmymmqihvtztcntodgwzvftunosqkwlskkgeecefempkivhkdbmwueknjzlyfiibpelexfklbtkbchznlcoivfzfwi", "bfgfezeqyvmlhvkikjzxbwybeciwkfunezthiecztlgmpskcstmowzfuvkvkhpokfzleatmciqdbwnmfndetlkoilni", "notnbzyssvlckzxieojcpkllkkwefmbecnkeihzfzicgeknvwmtbufquttfokliekwygvdvzzlmiwhapmqebftfhdmi", "ioddkxtheczglvfhlbzttmqfikjbbkiyckzkpavmklfwqmzesnemnwhsnbeiyuffuefvonligzmpctwwektkzeviocl", "scktfmxbqldflvzfthkkicwlkbzknfkqeufwmycyhilobbjeehvdiiwpngnzwetkmkgvzcztpzienualfsvoommetei", "gdnucbtevflpzvbcknfltxdtwpeiimtlhlbhjokfokkueemsiomzltsfyvziimainwcqykzmwzqhkgvkwzecebneffk", "ogeqieklkyzbztknifmqkakbigcbbelmjmhzsllscdfitctknnezvikevlcptmifwezofywvvexmdwtopnfkhwfuhuz", "wiliiqhklzvmcdwkelyvzecvboitgftqfcnfuwznkletkfeikjtfpleywsknodmghztmnxmfezhebsmkpibouvbaczk", "hkyqexfcclzuiukknnohhlybbtzsmoffaiwiplfiflebjznegzvpmwebzftsgtilwcckdzkettomkmvknqedkvweivm", "wyiufikotwfxclzseeommfiteeimwjktzovclsneepvimnghtqfaykekvpbzdckkvwfzkbhzcnduiqnflhbmgztlklb", "dbzhpsllmebeufgzetikmanepxcolfkinwvwhzczqkentbzjcozemqtolyfsubwvhgitdecikfvknfmvykmiiwfktlk", "nkdblttklveqfgikioetwizeblecwmvhfzgjideosmtmkvqtafmkccubiweophkuiklzznxzsmyzkbnynewcfhffvlp", "zwkwzwbjzinzpodyselkkmglittiokkfepkvzvmfnftahucekvtghzymklinbvcmqclmbxodewfeiefcbenhitqlufs", "bpztjuviimeiocgebfhblffkvkdxlkytmncswhnzcvkemtgtvatzedpwqbzumzeffeikwnswecloohfmkikknziqlly", "tckgcmzszviietmdkoevkmunlbobpclniokhdekslnbwecifkpzhmvefffvbthmwztganzxeekqiwwzqylitklfyjuf", "zwbetnzivdseyeygevmtvzptokitctvwimnwkmjimlnfpxkzogemlclbokbkbazqzlfeshhiucnfukliqdkwfefhcfk", "ncmmmhzfwcluzidgvdseklvonbwfyhbcptbklkzmiltizlenvfzotihokfkajncfeywttqxekkefspumekqzwiiebvg", "dwvkkzcftwmmoholzbznmkqhmveiedcozevkwuftjiucetppacehlimwevenzgtyifklilbzfqtbkxlsnbfngkksiyf", "zomizevzzctwifbiwflnifhkncgefnwlaxmztmvimqlobcvepthwdcseegufypjkontkyeksevmizbbhltkulqkkkfd", "jhetintgezpeqizkzwswckkwbkfvckinkhpidfmgbmyltkznobfmsnoftkzuzofvcvlxeayhmdfwuebvcililmetlqe", "icokjlffmlfkczkoevonnzezqimsmyvyntbeuklbeqtskdgheickizkmembpizvzfwlviecbnhwaxktgtfptulwdwhf", "ikvqpukbtnihqvanlzozxnmhenzijyzbmhslbfeiewtletvkkcgczmuzfgmtlfedfcboykwflvmtiwsckeidekfkowp", "ziitzmfgihdhbxempwlmyvznuewvstncfzejkeiinwokznyckpqbvlfclflkeesmkdkbbatmtulkztihwqkovcffego", "vutqlietkzmzngfctklpkbfcdizkxvdfpyeeiqsnhjnbkiwhwevtzkvgummcezlofiemstayfocimhwfblzbkwenkol", "kmihfameimbucdnnzwveoiifpkhzxtzyehobslvzfnqlycknkickjvkwfgtecskilqlvleutfbepbfokwmmttwgzzde", "kfvpdtecytkhpdkcwkumyzeihzneqsibwfelizkikklvboegcgovnwnxfkzntmobimzlsbftfeveliczjqawlmtumfh", "kmlmkmfwncisiwkttvbkmmznfogalepkezcgtziknlelfxpwkjqhiiuyebzecdeotwfvqzvyuozstnvckfldbhihefb", "twfibkiulcklivdfelcpczscfekhafhfiqyimxkwpbwsefzzmjteemdynlmgbnkkonvzvzkgnmitqwebtkooztevuhl", "eyojzeffstifvhwmqllikmztzlimifuiolhgyebkpphumikznwgkdoxetcfmkbzntqzbadkvlcvkkwtwecfcbseenvn", "szkznzpsakfizeltmwwvtdwvklcyetdmfvufkiheljczoeblpcxzowycmhkuligqihmiifkebkmqbngenktbvneofft"};

        System.out.println(str.length);
    }
}


