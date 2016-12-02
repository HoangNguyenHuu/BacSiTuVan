package doctor.controller;

import java.util.ArrayList;
import java.util.Arrays;

import doctor.model.Event;
import doctor.model.EventLayer;
import doctor.model.InferenceTree;
import doctor.model.Rule;

public class Test {
	public static void main(String[] args) {
		String id1 = "1101";// Tuổi < 12 (Trẻ em)
		String id2 = "1102";// Tuổi >=12 (Người lớn)

		String id3 = "1111";// Nam
		String id4 = "1112";// Nữ

		String id5 = "1201";// Nhiệt độ từ 36,5 C đến 37,5 C
		String id6 = "1202";// Nhiệt độ từ 37,5 C đến 38,5 C
		String id7 = "1203";// Nhiệt độ từ 38,5 C đến 39 C
		String id8 = "1204";// Nhiệt độ từ 39 đến 40 C
		String id9 = "1205"; // Nhiệt độ lớn hơn 40 C
		String id10 = "1206"; // Thân nhiệt bình thường
		String id11 = "1207"; // Sốt nhẹ
		String id12 = "1208"; // Sốt vừa
		String id13 = "1209"; // Sốt cao
		String id14 = "1210";// Sốt rất cao

		String id15 = "1301";// Nhỏ < 65 lần/ phút (chậm)
		String id16 = "1302";// Từ 65 đến 80 lần/phút (bình thường)
		String id17 = "1303";// > 80 lần/phút (nhanh)
		String id18 = "1304";// nhịp tim chậm
		String id19 = "1305"; // nhịp tim bình thường
		String id20 = "1306"; // nhịp tim nhanh

		String id21 = "1401";// Ho thường
		String id22 = "1402";// Ho khan
		String id23 = "1403";// Ho đờm
		String id24 = "1404";// Chảy mũi
		String id25 = "1405";// Đau đầu
		String id26 = "1406";// Buồn nôn
		String id27 = "1407";// Ói mửa
		String id28 = "1408";// Tức ngực
		String id29 = "1409";// Tiêu chảy
		String id30 = "1410";// Hắt hơi
		String id31 = "1411";// Rối loạn ý thức
		String id32 = "1412";// Phát ban
		String id33 = "1413";// Chảy máu dưới da
		String id34 = "1414";// Chảy máu chân răng
		String id35 = "1415";// Đau họng
		String id36 = "1416";// Chảy máu mũi
		String id37 = "1417";// Sưng hạch

		String id38 = "2101";// Bệnh nhân bị cúm A H1N1
		String id39 = "2102";// Bệnh nhân bị cúm A H3N2
		String id40 = "2103";// Bệnh nhân bị cúm A H5N1
		String id41 = "2104";// Bệnh nhân bị cúm B
		String id42 = "2105";// Bệnh nhân bị cảm lạnh
		String id43 = "2106";// Bệnh nhân bị cảm nóng
		String id44 = "2107";// Bệnh nhân bị sốt phát ban
		String id45 = "2108";// Bệnh nhân bị sốt siêu vi
		String id46 = "2109";// Bệnh nhân bị sốt xuất huyết

		String id47 = "3101"; // Thuốc cho người lớn bị H1N1
		String id48 = "3102"; // Thuốc cho trẻ em bị H1N1
		String id49 = "3103"; // Thuốc cho người lớn bị H5N1
		String id50 = "3104"; // Thuốc cho trẻ em bị H5N1
		String id51 = "3105"; // Thuốc cho người bị H3N2
		String id52 = "3106"; // Thuốc cho người bị cúm B
		String id53 = "3107"; // Thuốc cho người bị cảm lạnh
		String id54 = "3108"; // Thuốc cho người bị cảm nóng
		String id55 = "3109"; // Thuốc cho người lớn bị sốt phát ban
		String id56 = "3110"; // Thuốc cho trẻ em bị sốt phát ban
		String id57 = "3111"; // Thuốc cho người lớn bị sốt siêu vi
		String id58 = "3112"; // Thuốc cho trẻ em bị sốt siêu vi
		String id59 = "3113"; // Thuốc cho người bị sốt xuất huyết.

		String id60 = "4101"; // Lời khuyên cho người bị cúm A, cúm B
		String id61 = "4102"; // Lời khuyên cho người bị cảm lạnh
		String id62 = "4103"; // Lời khuyên cho người bị cảm nóng
		String id63 = "4104"; // Lời khuyên cho người bị sốt phát ban
		String id64 = "4105"; // Lời khuyên cho người bị sốt siêu vi
		String id65 = "4106"; // Lời khuyên cho người bị sốt xuất huyết

		Event ev1 = new Event(id1, "Trẻ em", 0);
		Event ev2 = new Event(id2, "Người lớn", 0);
		Event ev3 = new Event(id3, "Nam", 0);
		Event ev4 = new Event(id4, "Nữ", 0);
		Event ev5 = new Event(id5, "Nhiệt độ từ 36,5 đến 37,5", 0);
		Event ev6 = new Event(id6, "Nhiệt độ từ 37,5 đến 38,5", 0);
		Event ev7 = new Event(id7, "Nhiệt độ từ 38,5 đến 39", 0);
		Event ev8 = new Event(id8, "Nhiệt độ từ 39 đến 40", 0);
		Event ev9 = new Event(id9, "Nhiệt độ >40", 0);
		Event ev10 = new Event(id10, "Thân nhiệt bình thường", 0);
		Event ev11 = new Event(id11, "Sốt nhẹ", 0);
		Event ev12 = new Event(id12, "Sốt vừa", 0);
		Event ev13 = new Event(id13, "Sốt cao", 0);
		Event ev14 = new Event(id14, "Sốt rất cao", 0);
		Event ev15 = new Event(id15, "Nhịp tim nhỏ hơn 65 lần/phút", 0);
		Event ev16 = new Event(id16, "Nhịp tim từ 65 đến 80 lần/phút", 0);
		Event ev17 = new Event(id17, "Nhịp tim > 80 lần/phút", 0);
		Event ev18 = new Event(id18, "Nhịp tim chậm", 0);
		Event ev19 = new Event(id19, "Nhịp tim bình thường", 0);
		Event ev20 = new Event(id20, "Nhịp tim nhanh", 0);
		Event ev21 = new Event(id21, "Ho thường", 0);
		Event ev22 = new Event(id22, "Ho khan", 0);
		Event ev23 = new Event(id23, "Ho đờm", 0);
		Event ev24 = new Event(id24, "Chảy mũi", 0);
		Event ev25 = new Event(id25, "Đau đầu", 0);
		Event ev26 = new Event(id26, "Buồn nôn", 0);
		Event ev27 = new Event(id27, "Ói mửa", 0);
		Event ev28 = new Event(id28, "Tức ngực", 0);
		Event ev29 = new Event(id29, "Tiêu chảy", 0);
		Event ev30 = new Event(id30, "Hắt hơi", 0);
		Event ev31 = new Event(id31, "Rối loạn ý thức", 0);
		Event ev32 = new Event(id32, "Phát ban", 0);
		Event ev33 = new Event(id33, "Chảy máu dưới da", 0);
		Event ev34 = new Event(id34, "Chảy máu chân răng", 0);
		Event ev35 = new Event(id35, "Đau họng", 0);
		Event ev36 = new Event(id36, "Chảy máu mũi", 0);
		Event ev37 = new Event(id37, "Sưng hạch", 0);
		Event ev38 = new Event(id38, "Bệnh nhân bị cúm A H1N1", 0);
		Event ev39 = new Event(id39, "Bệnh nhân bị cúm A H3N2", 0);
		Event ev40 = new Event(id40, "Bệnh nhân bị cúm A H5N1", 0);
		Event ev41 = new Event(id41, "Bệnh nhân bị cúm B", 0);
		Event ev42 = new Event(id42, "Bệnh nhân bị cảm lạnh", 0);
		Event ev43 = new Event(id43, "Bệnh nhân bị cảm nóng", 0);
		Event ev44 = new Event(id44, "Bệnh nhân bị sốt phát ban", 0);
		Event ev45 = new Event(id45, "Bệnh nhân bị sốt siêu vi", 0);
		Event ev46 = new Event(id46, "Bệnh nhân bị sốt xuất huyết", 0);
		Event ev47 = new Event(id47, "Tamiflu: 75 mg/lần, 2 lần/ngày, 5 ngày", 0);
		Event ev48 = new Event(id48, "Tamiflu: 30 mg/lần, 2 lần/ngày, 5 ngày", 0);
		Event ev49 = new Event(id49, "Arbido (Fludon) : 200 mg/ ngày, 5 ngày", 0);
		Event ev50 = new Event(id50, "Arbido (Fludon) : 50 mg/ ngày, 5 ngày", 0);
		Event ev51 = new Event(id51,
				"Bệnh này có nhiều biến chứng nguy hiểm, hãy đưa bệnh nhân tới các cơ sở y tế để điều trị tốt nhất", 0);
		Event ev52 = new Event(id52, "Cúm B là loại cúm nhẹ, chỉ cần nghỉ ngơi vài ngày là khỏi.", 0);
		Event ev53 = new Event(id53,
				"1 củ gừng tươi 15 – 20g, rửa sạch, thái lát, đổ 100ml nước đun sôi 20 phút, gạn ra, thêm đường và uống nóng",
				0);
		Event ev54 = new Event(id54,
				"rau má tươi 12g, lá tre 12g, lá hương nhu 16g, củ sắn dây thái lát 12g. Nước vừa đủ, sắc uống ngày 1 thang chia 3 lần uống",
				0);
		Event ev55 = new Event(id55, " acetaminophen, 400mg", 0);
		Event ev56 = new Event(id56, " acetaminophen, 200mg", 0);
		Event ev57 = new Event(id57, " paracetamol, 400mg", 0);
		Event ev58 = new Event(id58, " paracetamol, 200mg", 0);
		Event ev59 = new Event(id59,
				" Đây là loại sốt nguy hiểm, cần đưa ngay tới các cơ sở y tế để được điều trị kịp thời", 0);
		Event ev60 = new Event(id60,
				" Tăng cường vệ sinh cá nhân: tắm rửa, rửa tay bằng xà phòng. Vệ sinh chỗ ở sạch sẽ, thoáng mát. Đeo khẩu trang khi ra ngoài.",
				0);
		Event ev61 = new Event(id61,
				" Mặc ấm khi ra đường, gồm cả mũ, giày, khẩu trang để không bị lạnh xâm nhập. Ăn thức ăn và uống nước còn nóng, tránh hút thuốc và tập thể dục thường xuyên.",
				0);
		Event ev62 = new Event(id62,
				" Tránh ra ngoài đường nắng nóng khi không cần thiết, nếu đi cần che kín toàn thân để không bị nắng chiếu vào. Đi lại hoặc nằm nghỉ ở những nơi thoáng mát. Tránh ăn đồ cay nóng, tránh làm việc quá sức.",
				0);
		Event ev63 = new Event(id63,
				" Nghỉ ngơi và điều trị tại nhà, tránh lây bệnh cho người khác. Vệ sinh thân thể bằng nước muối ấm, tránh dùng nước lạnh. Bổ sung vitamin C và uống thuốc khi bị sốt. Nếu có dấu hiệu biến chứng lạ, cần đưa đến cơ sở y tế để kịp thời chữa trị.",
				0);
		Event ev64 = new Event(id64,
				"Đảm bảo vệ sinh ăn uống, môi trường sống thoáng mát sạch sẽ. Người chăm sóc luôn cần đeo khẩu trang khi chăm sóc bệnh nhân. Đưa ngay tới các cơ sở khám chữa bệnh để điều trị nếu có các biểu hiện lạ như: tím tái, co giật, nôn ói liên tục,...",
				0);
		Event ev65 = new Event(id65,
				" Vệ sinh môi trường sạch sẽ, đặc biệt là các đồ chứa, bể đựng nước, tránh cho muỗi phát triển. Khi ngủ cần dùng màn. Đưa đến cơ sở khám chữa bệnh nếu tiếp tục có biểu hiện lạ",
				0);

		ArrayList<String> listID1 = new ArrayList<>(Arrays.asList(id5));
		ArrayList<String> listID2 = new ArrayList<>(Arrays.asList(id6));
		ArrayList<String> listID3 = new ArrayList<>(Arrays.asList(id7));
		ArrayList<String> listID4 = new ArrayList<>(Arrays.asList(id8));
		ArrayList<String> listID5 = new ArrayList<>(Arrays.asList(id9));
		ArrayList<String> listID6 = new ArrayList<>(Arrays.asList(id15));
		ArrayList<String> listID7 = new ArrayList<>(Arrays.asList(id16));
		ArrayList<String> listID8 = new ArrayList<>(Arrays.asList(id17));
		ArrayList<String> listID9 = new ArrayList<>(Arrays.asList(id12, id22));
		ArrayList<String> listID10 = new ArrayList<>(Arrays.asList(id12, id22, id24));
		ArrayList<String> listID11 = new ArrayList<>(Arrays.asList(id12, id22, id25));
		ArrayList<String> listID12 = new ArrayList<>(Arrays.asList(id12, id22, id24, id25));
		ArrayList<String> listID13 = new ArrayList<>(Arrays.asList(id12, id23));
		ArrayList<String> listID14 = new ArrayList<>(Arrays.asList(id12, id23, id24));
		ArrayList<String> listID15 = new ArrayList<>(Arrays.asList(id12, id23, id25));
		ArrayList<String> listID16 = new ArrayList<>(Arrays.asList(id12, id23, id24, id25));
		ArrayList<String> listID17 = new ArrayList<>(Arrays.asList(id12, id23, id29));
		ArrayList<String> listID18 = new ArrayList<>(Arrays.asList(id12, id23, id24, id29));
		ArrayList<String> listID19 = new ArrayList<>(Arrays.asList(id12, id23, id24, id25, id29));
		ArrayList<String> listID20 = new ArrayList<>(Arrays.asList(id13, id21));
		ArrayList<String> listID21 = new ArrayList<>(Arrays.asList(id13, id21, id26));
		ArrayList<String> listID22 = new ArrayList<>(Arrays.asList(id13, id21, id28));
		ArrayList<String> listID23 = new ArrayList<>(Arrays.asList(id13, id21, id20));
		ArrayList<String> listID24 = new ArrayList<>(Arrays.asList(id13, id21, id26, id20));
		ArrayList<String> listID25 = new ArrayList<>(Arrays.asList(id13, id21, id28, id20));
		ArrayList<String> listID26 = new ArrayList<>(Arrays.asList(id13, id21, id26, id28));
		ArrayList<String> listID27 = new ArrayList<>(Arrays.asList(id13, id21, id26, id28, id20));
		ArrayList<String> listID28 = new ArrayList<>(Arrays.asList(id14, id21, id26, id28));
		ArrayList<String> listID29 = new ArrayList<>(Arrays.asList(id11));
		ArrayList<String> listID30 = new ArrayList<>(Arrays.asList(id10, id21));
		ArrayList<String> listID31 = new ArrayList<>(Arrays.asList(id10, id21, id30));
		ArrayList<String> listID32 = new ArrayList<>(Arrays.asList(id11, id21));
		ArrayList<String> listID33 = new ArrayList<>(Arrays.asList(id11, id21, id30));
		ArrayList<String> listID34 = new ArrayList<>(Arrays.asList(id14, id25));
		ArrayList<String> listID35 = new ArrayList<>(Arrays.asList(id14, id20));
		ArrayList<String> listID36 = new ArrayList<>(Arrays.asList(id14, id31));
		ArrayList<String> listID37 = new ArrayList<>(Arrays.asList(id14, id25, id20));
		ArrayList<String> listID38 = new ArrayList<>(Arrays.asList(id14, id20, id31));
		ArrayList<String> listID39 = new ArrayList<>(Arrays.asList(id14, id25, id31));
		ArrayList<String> listID40 = new ArrayList<>(Arrays.asList(id14, id25, id20, id31));
		ArrayList<String> listID41 = new ArrayList<>(Arrays.asList(id14, id24, id32, id37));
		ArrayList<String> listID42 = new ArrayList<>(Arrays.asList(id14, id24, id32));
		ArrayList<String> listID43 = new ArrayList<>(Arrays.asList(id14, id32, id37));
		ArrayList<String> listID44 = new ArrayList<>(Arrays.asList(id14, id32));
		ArrayList<String> listID45 = new ArrayList<>(Arrays.asList(id12, id24, id25, id27, id29));
		ArrayList<String> listID46 = new ArrayList<>(Arrays.asList(id12, id25, id27, id29));
		ArrayList<String> listID47 = new ArrayList<>(Arrays.asList(id12, id25, id27));
		ArrayList<String> listID48 = new ArrayList<>(Arrays.asList(id12, id25, id29));
		ArrayList<String> listID49 = new ArrayList<>(Arrays.asList(id13, id25, id33, id34, id37));
		ArrayList<String> listID50 = new ArrayList<>(Arrays.asList(id13, id25, id33));
		ArrayList<String> listID51 = new ArrayList<>(Arrays.asList(id13, id25, id34));
		ArrayList<String> listID52 = new ArrayList<>(Arrays.asList(id13, id25, id37));
		ArrayList<String> listID53 = new ArrayList<>(Arrays.asList(id38, id2));
		ArrayList<String> listID54 = new ArrayList<>(Arrays.asList(id38, id1));
		ArrayList<String> listID55 = new ArrayList<>(Arrays.asList(id39));
		ArrayList<String> listID56 = new ArrayList<>(Arrays.asList(id40, id2));
		ArrayList<String> listID57 = new ArrayList<>(Arrays.asList(id40, id1));
		ArrayList<String> listID58 = new ArrayList<>(Arrays.asList(id41));
		ArrayList<String> listID59 = new ArrayList<>(Arrays.asList(id42));
		ArrayList<String> listID60 = new ArrayList<>(Arrays.asList(id43));
		ArrayList<String> listID61 = new ArrayList<>(Arrays.asList(id44, id2));
		ArrayList<String> listID62 = new ArrayList<>(Arrays.asList(id44, id1));
		ArrayList<String> listID63 = new ArrayList<>(Arrays.asList(id45, id2));
		ArrayList<String> listID64 = new ArrayList<>(Arrays.asList(id45, id1));
		ArrayList<String> listID65 = new ArrayList<>(Arrays.asList(id46));
		ArrayList<String> listID66 = new ArrayList<>(Arrays.asList(id38));
		ArrayList<String> listID67 = new ArrayList<>(Arrays.asList(id39));
		ArrayList<String> listID68 = new ArrayList<>(Arrays.asList(id40));
		ArrayList<String> listID69 = new ArrayList<>(Arrays.asList(id41));
		ArrayList<String> listID70 = new ArrayList<>(Arrays.asList(id42));
		ArrayList<String> listID71 = new ArrayList<>(Arrays.asList(id43));
		ArrayList<String> listID72 = new ArrayList<>(Arrays.asList(id44));
		ArrayList<String> listID73 = new ArrayList<>(Arrays.asList(id45));
		ArrayList<String> listID74 = new ArrayList<>(Arrays.asList(id46));

		Rule rule1 = new Rule("r1", id10, listID1, 0.9);
		Rule rule2 = new Rule("r2", id11, listID2, 0.9);
		Rule rule3 = new Rule("r3", id12, listID3, 0.9);
		Rule rule4 = new Rule("r4", id13, listID4, 0.9);
		Rule rule5 = new Rule("r5", id14, listID5, 0.9);
		Rule rule6 = new Rule("r6", id12, listID2, 0.8);
		Rule rule7 = new Rule("r7", id12, listID4, 0.6);
		Rule rule8 = new Rule("r8", id13, listID5, 0.5);
		Rule rule9 = new Rule("r9", id18, listID6, 0.9);
		Rule rule10 = new Rule("r10", id19, listID7, 0.9);
		Rule rule11 = new Rule("r11", id20, listID8, 0.9);
		Rule rule12 = new Rule("r12", id19, listID8, 0.6);
		Rule rule13 = new Rule("r13", id38, listID9, 0.6);
		Rule rule14 = new Rule("r14", id38, listID10, 0.7);
		Rule rule15 = new Rule("r15", id38, listID11, 0.7);
		Rule rule16 = new Rule("r16", id38, listID12, 0.8);
		Rule rule17 = new Rule("r17", id39, listID13, 0.6);
		Rule rule18 = new Rule("r18", id39, listID14, 0.7);
		Rule rule19 = new Rule("r19", id39, listID15, 0.7);
		Rule rule20 = new Rule("r20", id39, listID16, 0.8);
		Rule rule21 = new Rule("r21", id39, listID17, 0.8);
		Rule rule22 = new Rule("r22", id39, listID18, 0.85);
		Rule rule23 = new Rule("r23", id39, listID19, 0.9);
		Rule rule24 = new Rule("r24", id40, listID20, 0.6);
		Rule rule25 = new Rule("r25", id40, listID21, 0.7);
		Rule rule26 = new Rule("r26", id40, listID22, 0.7);
		Rule rule27 = new Rule("r27", id40, listID23, 0.7);
		Rule rule28 = new Rule("r28", id40, listID24, 0.8);
		Rule rule29 = new Rule("r29", id40, listID25, 0.8);
		Rule rule30 = new Rule("r30", id40, listID26, 0.8);
		Rule rule31 = new Rule("r31", id40, listID27, 0.9);
		Rule rule32 = new Rule("r32", id40, listID28, 0.8);
		Rule rule33 = new Rule("r33", id41, listID29, 0.6);
		Rule rule34 = new Rule("r34", id42, listID30, 0.6);
		Rule rule35 = new Rule("r35", id42, listID31, 0.7);
		Rule rule36 = new Rule("r36", id42, listID32, 0.6);
		Rule rule37 = new Rule("r37", id42, listID33, 0.7);
		Rule rule38 = new Rule("r38", id43, listID34, 0.6);
		Rule rule39 = new Rule("r39", id43, listID35, 0.5);
		Rule rule40 = new Rule("r40", id43, listID36, 0.7);
		Rule rule41 = new Rule("r41", id43, listID37, 0.7);
		Rule rule42 = new Rule("r42", id43, listID38, 0.8);
		Rule rule43 = new Rule("r43", id43, listID39, 0.8);
		Rule rule44 = new Rule("r44", id43, listID40, 0.9);
		Rule rule45 = new Rule("r45", id44, listID41, 0.9);
		Rule rule46 = new Rule("r46", id44, listID42, 0.8);
		Rule rule47 = new Rule("r47", id44, listID43, 0.8);
		Rule rule48 = new Rule("r48", id44, listID44, 0.7);
		Rule rule49 = new Rule("r49", id45, listID45, 0.9);
		Rule rule50 = new Rule("r50", id45, listID46, 0.85);
		Rule rule51 = new Rule("r51", id45, listID47, 0.8);
		Rule rule52 = new Rule("r52", id45, listID48, 0.8);
		Rule rule53 = new Rule("r53", id46, listID49, 0.9);
		Rule rule54 = new Rule("r54", id46, listID50, 0.8);
		Rule rule55 = new Rule("r55", id46, listID51, 0.8);
		Rule rule56 = new Rule("r56", id46, listID52, 0.8);
		Rule rule57 = new Rule("r57", id47, listID53, 0.9);
		Rule rule58 = new Rule("r58", id48, listID54, 0.9);
		Rule rule59 = new Rule("r59", id51, listID55, 0.9);
		Rule rule60 = new Rule("r60", id49, listID56, 0.9);
		Rule rule61 = new Rule("r61", id50, listID57, 0.9);
		Rule rule62 = new Rule("r62", id52, listID58, 0.9);
		Rule rule63 = new Rule("r63", id53, listID59, 0.9);
		Rule rule64 = new Rule("r64", id54, listID60, 0.9);
		Rule rule65 = new Rule("r65", id55, listID61, 0.9);
		Rule rule66 = new Rule("r66", id56, listID62, 0.9);
		Rule rule67 = new Rule("r67", id57, listID63, 0.9);
		Rule rule68 = new Rule("r68", id58, listID64, 0.9);
		Rule rule69 = new Rule("r69", id59, listID65, 0.9);
		Rule rule70 = new Rule("r70", id60, listID66, 0.9);
		Rule rule71 = new Rule("r71", id60, listID67, 0.9);
		Rule rule72 = new Rule("r72", id60, listID68, 0.9);
		Rule rule73 = new Rule("r73", id60, listID69, 0.9);
		Rule rule74 = new Rule("r74", id61, listID70, 0.9);
		Rule rule75 = new Rule("r75", id62, listID71, 0.9);
		Rule rule76 = new Rule("r76", id63, listID72, 0.9);
		Rule rule77 = new Rule("r77", id64, listID73, 0.9);
		Rule rule78 = new Rule("r78", id65, listID74, 0.9);

		ArrayList<Rule> listAllRule = new ArrayList<>(Arrays.asList(rule1, rule2, rule3, rule4, rule5, rule6, rule7,
				rule8, rule9, rule10, rule11, rule12, rule13, rule14, rule15, rule16, rule17, rule18, rule19, rule20,
				rule21, rule22, rule23, rule24, rule25, rule26, rule27, rule28, rule29, rule30, rule31, rule32, rule33,
				rule34, rule35, rule36, rule37, rule38, rule39, rule40, rule41, rule42, rule43, rule44, rule45, rule46,
				rule47, rule48, rule49, rule50, rule51, rule52, rule53, rule54, rule55, rule56, rule57, rule58, rule59,
				rule60, rule61, rule62, rule63, rule64, rule65, rule66, rule67, rule68, rule69, rule70, rule71, rule72,
				rule73, rule74, rule75, rule76, rule77, rule78));

		ArrayList<Event> listAllEvent = new ArrayList<>(Arrays.asList(ev1, ev2, ev3, ev4, ev5, ev6, ev7, ev8, ev9, ev10,
				ev11, ev12, ev13, ev14, ev15, ev16, ev17, ev18, ev19, ev20, ev21, ev22, ev23, ev24, ev25, ev26, ev27,
				ev28, ev29, ev30, ev31, ev32, ev33, ev34, ev35, ev36, ev37, ev38, ev39, ev40, ev41, ev42, ev43, ev44,
				ev45, ev46, ev47, ev48, ev49, ev50, ev51, ev52, ev53, ev54, ev55, ev56, ev57, ev58, ev59, ev60, ev61,
				ev62, ev63, ev64, ev65));
		ReadWriteEventRule readWriteEventRule = new ReadWriteEventRule();
		readWriteEventRule.writeAllEvent(listAllEvent);
		readWriteEventRule.writeAllRule(listAllRule);
//		Event evTest = new Event("5000", "TestEvent", 0.0);
//		Rule ruleTest = new Rule("79", "test", listID27, 0.9);
//		readWriteEventRule.writeOneEvent(evTest);
//		readWriteEventRule.writeOneRule(ruleTest);
		
//		ArrayList<Event> myList = readWriteEventRule.readAllEvent();
//		for(int i = 0 ; i< myList.size(); i++){
//			Event tmp = myList.get(i);
//			System.out.println(tmp.getID() + " " + tmp.getName());
//		}
		
//		ArrayList<Rule> myListRule = readWriteEventRule.readAllRule();
//		for(int i =0; i< myListRule.size(); i++){
//			Rule tmp_rule = myListRule.get(i);
//			for(int j =0; j <tmp_rule.getListIDHypothesis().size(); j++){
//				System.out.print(tmp_rule.getListIDHypothesis().get(j) + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		Event evupdate = new Event(id13, "Sốt cao", 0);
//		System.out.println(evupdate.getID() + " " + evupdate.getName());
//		readWriteEventRule.updateAnEvent(evupdate);
		
		
		
//		Rule ruleUpdate = new Rule("r23", id39 , listID1, 0.0);
//		readWriteEventRule.updateARule(rule23);
		
//		String nextRule = readWriteEventRule.getIdForNewRule();
//		System.out.println(nextRule);
		
		
		
		Event evTest1 = new Event("1205", 0.8);
		Event evTest2 = new Event("1405", 0.8);
		Event evTest3 = new Event("1303", 0.8);
		Event evTest4 = new Event("1411", 0.8);
		Event evTest5 = new Event("1410", 0.8);
		Event evTest6 = new Event("1101", 1.0);
		Event evTest7 = new Event("1111", 1.0);
		ArrayList<Event> listEventTest = new ArrayList<>(Arrays.asList(evTest1, evTest2, evTest3, evTest4, evTest5, evTest6, evTest7));
		InferenceTreeController inferenceTreeController = new InferenceTreeController(listAllRule, listAllEvent);
		Event result = inferenceTreeController.getDisease(listEventTest);
		listEventTest.add(result);
		System.out.println("Bệnh: " + result.getName());
		Event medicine = inferenceTreeController.getMedicine(listEventTest);
		listEventTest.add(medicine);
		System.out.println("Thuốc: " + medicine.getName());
		Event advice = inferenceTreeController.getAdvice(listEventTest);
		System.out.println("Lời khuyên: " + advice.getName());
		
		// EventController eventController = new EventController(listAllEvent);

		// ArrayList<Event> listDisease = eventController.getListDisease();
		// InferenceTreeController inferenceTreeController = new
		// InferenceTreeController(listAllRule, listAllEvent);
		//
		// ArrayList<Event> resultDisease = new ArrayList<>();
		// for(int i = 0; i< listDisease.size(); i++){
		// String id = listDisease.get(i).getID();
		// String name = listDisease.get(i).getName();
		// double certain =
		// inferenceTreeController.getCertainFactorFromIdConclude(id,
		// listEventTest);
		// Event temp = new Event(id, name, certain);
		// resultDisease.add(temp);
		// }
		//
		// for(int i =0; i< resultDisease.size(); i++){
		// Event tmp = resultDisease.get(i);
		// System.out.println(tmp.getID() + " " + tmp.getName() + " " +
		// tmp.getCertainFactor());
		// }

		// LayerController layerController = new LayerController();
		// InferenceTree inferenceTree =
		// layerController.stratifyEventFromID(listAllRule, "2106");
		// inferenceTree.display();
		// System.out.println("---------------------------------------------------------------------");
		// ArrayList<InferenceTree> listTree =
		// layerController.dividedAllTree(inferenceTree);
		// for(int i =0; i< listTree.size(); i++){
		// System.out.println("Tree " + i);
		// ArrayList<EventLayer> listEventLayer =
		// inferenceTreeController.stratifyEventFromTree(listTree.get(i));
		// for(int j =0; j< listEventLayer.size(); j++){
		// listEventLayer.get(j).display();
		// }
		// System.out.println("---------------------");
		// }

	}
}
