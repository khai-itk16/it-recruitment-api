-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 09, 2020 lúc 02:32 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `it_recruitment_backup`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`account_id`, `email`, `password`, `status`, `username`, `address_id`) VALUES
(27, 'admin1@gmail.com', '$2a$10$PGuJBIPHyfUrbE6v4Ei9Ou7MD06g.Qj1782uWbjQMZd2Px1OhqL/m', 'ACTIVE', 'admin1', NULL),
(28, 'employer1@gmail.com', '$2a$10$3uN5lWZ1cnHOcWP8YKxBOew2KcSKQFwunSozLhLRLRwji07svVaYO', 'ACTIVE', 'employer1', 14),
(29, 'employer2@gmail.com', '$2a$10$XF6KOTwntL/URg.O5RRpX.mwfsndOss7LgWavpVsJyDebIohWQYha', 'ACTIVE', 'employer2', 15),
(30, 'employer3@gmail.com', '$2a$10$H.z94vnP0GfgmkpZu8f67uKX5OrCMlt9.om06iTyq0eH2dWWeVOUa', 'ACTIVE', 'employer3', 17),
(31, 'employer4@gmail.com', '$2a$10$FanBiK7hVsnE7ej9dBt0veGG0sHnQk8kDGExdziShS9Xkbi3pJJp6', 'ACTIVE', 'employer4', 21),
(32, 'candidate1@gmail.com', '$2a$10$Jqux8SMRICdny9kf718d1eW44jJiD1aJ4E7qVgw8A1381mzlR8m0W', 'ACTIVE', 'candidate1', 22),
(33, 'candidate2@gmail.com', '$2a$10$LVBZ7jV55lEK72dE/p62RuZCR7BjZ7cUn5V.fkQMamQSClcTfSlWa', 'ACTIVE', 'candidate2', 23),
(34, 'candidate3@gmail.com', '$2a$10$/0Hr/ZBw4sbRlg4uTiqGQuvurnnpGxgY8VSMi1rOb0gdT6GXkVe9u', 'ACTIVE', 'candidate3', 25),
(35, 'candidate4@gmail.com', '$2a$10$fCPeU5zHjIziSDrwhVB3UOe8u4V5mCadhj5qK7CUccGozM1NqyvBi', 'ACTIVE', 'candidate4', 26),
(36, 'candidate5@gmail.com', '$2a$10$y/UChCOR2LdlTQNLmNWJp.UbowCc1ob/5rxBP7zEIHrNzO.c5Bz1i', 'ACTIVE', 'candidate5', 27),
(37, 'candidate6@gmail.com', '$2a$10$CCiT5UsDUtOg1rhOkSRnkeGOrmXdv3vRndbq/Ip1aAXOqPhgxfega', 'ACTIVE', 'candidate6', 28),
(38, 'candidate7@gmail.com', '$2a$10$zgBfAAvqtwGf3uVn2MfeveOOMe3KZ/iUrbteo.Irru7/DvkKXBMdC', 'ACTIVE', 'candidate7', 29),
(39, 'candidate8@gmail.com', '$2a$10$5aNKQJQw7.5VmhRurCAF1OUyyQJq9jt2qsEjDg01.mEVHeMntZsl.', 'ACTIVE', 'candidate8', 30),
(40, 'candidate9@gmail.com', '$2a$10$Viw59TOA3//j7Y3aPAslJuFIjY07L33uBd2ctJg9cbhCDx5YjvCG.', 'ACTIVE', 'candidate9', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account_role`
--

CREATE TABLE `account_role` (
  `account_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account_role`
--

INSERT INTO `account_role` (`account_id`, `role_id`) VALUES
(27, 1),
(27, 2),
(28, 4),
(29, 4),
(30, 4),
(31, 4),
(32, 3),
(33, 3),
(34, 3),
(35, 3),
(36, 3),
(37, 3),
(38, 3),
(39, 3),
(40, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `address`
--

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `district` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `province` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `street` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ward` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `address`
--

INSERT INTO `address` (`address_id`, `district`, `province`, `street`, `ward`) VALUES
(14, '61', '3', '773 Ngô Quyền', '953'),
(15, '61', '3', '33 Phạm Tu', '953'),
(16, '56', '3', '344 đường 2 tháng 9', '925'),
(17, '56', '3', '344 đường 2 tháng 9', '925'),
(18, '56', '3', '81 Quang Trung', '920'),
(19, '56', '3', '81 Quang Trung', '920'),
(20, '56', '3', '81 Quang Trung', '920'),
(21, '56', '3', '81 Quang Trung', '920'),
(22, '59', '3', 'Nguyễn Lương Bằng', '946'),
(23, '59', '3', 'Nguyễn Lương Bằng', '944'),
(24, '59', '3', 'Nguyễn Lương Bằng', '944'),
(25, '59', '3', 'Nguyễn Lương Bằng', '944'),
(26, '59', '3', 'Nguyễn Lương Bằng', '946'),
(27, '59', '3', 'Nguyễn Lương Bằng', '946'),
(28, '59', '3', 'Nguyễn Lương Bằng', '946'),
(29, '59', '3', 'Nguyễn Lương Bằng', '946'),
(30, '59', '3', 'Nguyễn Lương Bằng', '946');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `candidate_resume`
--

CREATE TABLE `candidate_resume` (
  `account_id` int(11) NOT NULL,
  `achievement` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `candidate_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `foreign_language` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `job_objective` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `num_year_experience` int(11) NOT NULL,
  `phone` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `salary_expect` int(11) NOT NULL,
  `job_position_id` int(11) DEFAULT NULL,
  `job_type_id` int(11) DEFAULT NULL,
  `sex` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `candidate_resume`
--

INSERT INTO `candidate_resume` (`account_id`, `achievement`, `birthday`, `candidate_name`, `foreign_language`, `job_objective`, `num_year_experience`, `phone`, `salary_expect`, `job_position_id`, `job_type_id`, `sex`) VALUES
(32, NULL, '1998-11-18', 'Nguyễn Quang Hải', NULL, '<p>Tìm kiếm công việc lập trình viên trong môi trường làm việc chuyên nghiệp và năng động để có thể phát huy được năng lực bản thân trong việc phát triển các sản phẩm phần mềm chất lượng. Môi trường làm việc nhiều thử thách là động lực và cơ hội để tôi hoàn thiện kiến thức nghề nghiệp và trở thành một lập trình viên giỏi.</p>', 1, '0123123123', 0, 3, 2, b'1'),
(33, NULL, '1997-11-04', 'Đỗ Hùng Dũng', NULL, '<p>Tìm kiếm công việc lập trình viên trong môi trường làm việc chuyên nghiệp và năng động để có thể phát huy được năng lực bản thân trong việc phát triển các sản phẩm phần mềm chất lượng. Môi trường làm việc nhiều thử thách là động lực và cơ hội để tôi hoàn thiện kiến thức nghề nghiệp và trở thành một lập trình viên giỏi.</p>', 2, '0123123123', 0, 4, 2, b'1'),
(34, '<ul><li>Đạt học bổng khuyến khích tại trường ĐH Bách Khoa Đà Nẵng vào năm 2019</li></ul>', '1998-03-19', 'Nguyễn Tiến Linh', '<ul><li>Có bằng Toeic 650, thi ngày 18-10-2019 tại IIG Đà Nẵng</li></ul>', '<p>Tìm kiếm công việc lập trình viên trong môi trường làm việc chuyên nghiệp và năng động để có thể phát huy được năng lực bản thân trong việc phát triển các sản phẩm phần mềm chất lượng. Môi trường làm việc nhiều thử thách là động lực và cơ hội để tôi hoàn thiện kiến thức nghề nghiệp và trở thành một lập trình viên giỏi.</p>', 1, '0123123123', 0, 1, 3, b'1'),
(35, NULL, '1996-11-04', 'Lương Xuân Trường', NULL, '<p>Tìm kiếm công việc lập trình viên trong môi trường làm việc chuyên nghiệp và năng động để có thể phát huy được năng lực bản thân trong việc phát triển các sản phẩm phần mềm chất lượng. Môi trường làm việc nhiều thử thách là động lực và cơ hội để tôi hoàn thiện kiến thức nghề nghiệp và trở thành một lập trình viên giỏi.</p>', 2, '0123123123', 10000000, 3, 2, b'1'),
(36, NULL, '1997-11-05', 'Nguyễn Tuấn Anh', NULL, '<p>Tìm kiếm công việc lập trình viên trong môi trường làm việc chuyên nghiệp và năng động để có thể phát huy được năng lực bản thân trong việc phát triển các sản phẩm phần mềm chất lượng. Môi trường làm việc nhiều thử thách là động lực và cơ hội để tôi hoàn thiện kiến thức nghề nghiệp và trở thành một lập trình viên giỏi.</p>', 1, '0123123123', 0, 3, 2, b'1'),
(37, NULL, '1999-11-12', 'Đoàn Văn Hậu', NULL, '<p>Tìm kiếm công việc lập trình viên trong môi trường làm việc chuyên nghiệp và năng động để có thể phát huy được năng lực bản thân trong việc phát triển các sản phẩm phần mềm chất lượng. Môi trường làm việc nhiều thử thách là động lực và cơ hội để tôi hoàn thiện kiến thức nghề nghiệp và trở thành một lập trình viên giỏi.</p>', 1, '0123123123', 0, 3, 2, b'1'),
(38, NULL, '1997-11-10', 'Nguyễn Văn Toàn', NULL, '<p>Tìm kiếm công việc lập trình viên trong môi trường làm việc chuyên nghiệp và năng động để có thể phát huy được năng lực bản thân trong việc phát triển các sản phẩm phần mềm chất lượng. Môi trường làm việc nhiều thử thách là động lực và cơ hội để tôi hoàn thiện kiến thức nghề nghiệp và trở thành một lập trình viên giỏi.</p>', 3, '0123123123', 0, 3, 2, b'1'),
(39, NULL, '1996-11-12', 'Nguyễn Công Phượng', NULL, '<p>Tìm kiếm công việc lập trình viên trong môi trường làm việc chuyên nghiệp và năng động để có thể phát huy được năng lực bản thân trong việc phát triển các sản phẩm phần mềm chất lượng. Môi trường làm việc nhiều thử thách là động lực và cơ hội để tôi hoàn thiện kiến thức nghề nghiệp và trở thành một lập trình viên giỏi.</p>', 2, '0123123123', 0, 3, 2, b'1'),
(40, NULL, NULL, NULL, NULL, '<p>Tìm kiếm công việc lập trình viên trong môi trường làm việc chuyên nghiệp và năng động để có thể phát huy được năng lực bản thân trong việc phát triển các sản phẩm phần mềm chất lượng. Môi trường làm việc nhiều thử thách là động lực và cơ hội để tôi hoàn thiện kiến thức nghề nghiệp và trở thành một lập trình viên giỏi.</p>', 0, '0123123123', 0, NULL, NULL, b'0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `education`
--

CREATE TABLE `education` (
  `education_id` int(11) NOT NULL,
  `degree_time` date DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_degree` bit(1) NOT NULL,
  `school` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `education`
--

INSERT INTO `education` (`education_id`, `degree_time`, `description`, `is_degree`, `school`, `account_id`) VALUES
(25, NULL, 'Sinh viên khoa: Công nghệ thông tin\nChuyên ngành: Công nghệ phần mềm\nGPA: 3.0/4', b'0', 'Trường ĐH Bách Khoa Đà Nẵng', 32),
(26, '2020-05-31', '- Kỹ sư Công nghệ thông tin\n- Tốt nghiệp loại xuất sắc', b'1', 'Trường ĐH Bách Khoa Đà Nẵng', 33),
(27, NULL, 'Sinh viên khoa công nghệ thông tin\nchuyên ngành công nghệ phần mềm\nGPA: 3.4/4', b'0', 'Trường ĐH Bách Khoa Đà Nẵng', 34),
(28, '2018-11-04', 'Kỹ sư công nghệ thông tin\nChuyên ngành hệ thống thông tin\nTốt nghiệp loại giỏi', b'1', 'Trường ĐH Bách Khoa Đà Nẵng', 35),
(29, '2020-11-05', 'Kỹ sư công nghệ thông tin\nChuyên ngành mạng máy tính\nTốt nghiệp loại khá', b'1', 'Trường ĐH Bách Khoa Đà Nẵng', 36),
(30, '2020-11-05', 'Kỹ sư công nghệ thông tin\nChuyên ngành mạng máy tính\nTốt nghiệp loại khá', b'0', 'Trường ĐH Bách Khoa Đà Nẵng', 36),
(31, NULL, 'Sinh Viên Khoa công nghệ thông tin\nChuyên ngành hệ thống thông tin\nGPA: 3.2/4', b'0', 'Trường ĐH Bách Khoa Đà Nẵng', 37),
(32, '2019-08-06', 'Kỹ sư công nghệ thông tin\nTốt nghiệp loại xuất sắc', b'1', 'Trường ĐH Bách Khoa Đà Nẵng', 38),
(33, '2020-11-04', 'Kỹ sư công nghệ thông tin\nchuyên ngành công nghệ phần mềm\nTốt nghiệp loại giỏi', b'1', 'Trường ĐH Bách Khoa Đà Nẵng', 39);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employer_resume`
--

CREATE TABLE `employer_resume` (
  `account_id` int(11) NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `employer_name` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `num_member` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `overview` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `work_time` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `employer_resume`
--

INSERT INTO `employer_resume` (`account_id`, `description`, `employer_name`, `num_member`, `overview`, `work_time`) VALUES
(28, '<p><strong>#&nbsp;Môi trường chuyên nghiệp, cởi mở, đề cao sự sáng tạo:</strong></p><ul><li>Làm việc cùng những đồng nghiệp có lý tưởng thay đổi xã hội.</li><li>Coi trọng những góc nhìn khác biệt trong tập thể</li><li>Văn hóa học tập mạnh mẽ và thúc đẩy phát triển</li><li>Văn hoá chấp nhận rủi ro để trải nghiệm và phát triển</li></ul><p><strong># Tập trung hỗ trợ sự phát triển cá nhân:</strong></p><ul><li>Được tư vấn, đồng hành và hỗ trợ phát triển sự nghiệp cùng với hệ thống career path (phát triển theo hướng chuyên gia hoặc hướng quản lý) đã được nghiên cứu, thử nghiệm trong nhiều năm</li><li>Được định hướng mục tiêu cá nhân, nhóm và tổ chức</li><li>Trao quyền làm chủ</li><li>Hỗ trợ xác định mục tiêu 3 tháng-6 tháng (Goal Define Support)</li></ul><p><strong>&nbsp;#&nbsp;Quan tâm đặc biệt tới nhân viên:</strong><br>&nbsp;</p><ul><li>Mức lương cạnh tranh cùng các khoản trợ cấp, phụ cấp khác (ăn trưa, đi lại, phái đẹp, tiếng Nhật, chứng chỉ IT,..v.v...)</li><li>Lương tháng 13</li><li>Performance review: 2 lần/năm</li><li>Bảo hiểm sức khoẻ toàn diện Sun* Care</li><li>Chế độ thâm niên</li><li>Chế độ chăm sóc phụ nữ: Nghỉ sinh lý phụ nữ: 2,5h/ tháng; nghỉ sau sinh cho nhân viên nữ có con dưới 1 tuổi: 1h/ngày</li><li>Chính sách hỗ trợ các hoạt động học tập, trao đổi, chia sẻ kiến thức, giao lưu văn hoá (Seminar công nghệ - Tech Expert, CLB: đọc sách, tiếng Nhật, CLB âm nhạc,...)</li><li>Du lịch thường niên, hoạt động team building hàng quý.</li></ul>', 'Sun* Inc.', '1000+', '<p>Digital Creative Studio With Top 1% Talent In Asia</p><p>&nbsp;</p><p><strong>Sun* Inc.</strong> được thành lập vào năm 2012, là một Digital Creative Studio hiện có hơn 1300 thành viên tại 6 thành phố ở 4 quốc gia Châu Á</p><p>Tại Sun*, chúng tôi tham gia tư vấn cho khách hàng với tư cách là công ty chuyên nghiệp trên nhiều lĩnh vực khác nhau, không chỉ về lập trình hay thiết kế mà cả quản lý dự án, tư vấn thiết kế và kinh doanh, cung cấp tài chính hay marketing. Bên cạnh đó, Sun* còn tạo ra các dịch vụ, lĩnh vực kinh doanh mới và thành lập các công ty con.</p><p>Sun* mang hình ảnh của một “Studio”, tập trung những chuyên gia luôn luôn đam mê tìm kiếm giải pháp. Thế giới mà chúng tôi đang hướng tới là thế giới mà ở đó có những con người mang đam mê và hoài bão tạo ra giá trị mới khiến xã hội trở nên tốt đẹp hơn.</p><p>&nbsp;</p><p>Để xứng đáng với cái tên gọi “Mặt trời”, chúng tôi sẽ toàn tâm toàn ý, nỗ lực hết mình để nuôi dưỡng mầm ươm mang tên “Awesome things”.</p>', 'Thứ 2 - Thứ 6'),
(29, '<p>• Mức lương cạnh tranh và Thưởng dựa trên thành tích.</p><p>• Phần thưởng ký kết: 10M (Test3), 15M (Test4), 20M (Test5)</p><p>• Có cơ hội thăng tiến lên các vị trí cao hơn.</p><p>• Làm việc và phát triển trong môi trường chuyên nghiệp.</p><p>• FPT Care và nhiều lợi ích khác…</p>', 'FPT Software', '1000+', '<p><strong>Fsoft DN</strong> được thành lập vào ngày 13-8-2005, tính đến nay sau khoảng hơn 10 năm hoạt động&nbsp;FPT Software Đà Nẵng đã không ngừng lớn mạnh và trở thành công ty công nghệ thông tin có quy mô lớn nhất miền Trung. Ngày 13/8/2016, đơn vị đã tổ chức lễ kỷ niệm 10 năm thành lập với sự tham dự của hơn 1500 nhân viên và các lãnh đạo cấp cao, bạn bè đối tác. Năm 2016, chi nhánh tiếp tục khánh thành khu làm việc mới <strong>FPT&nbsp;Complex</strong>, công trình phức tiêu chuẩn quốc tế&nbsp;tại Khu đô thị FPT City. Năm 2020, Đà Nẵng sẽ hướng tới mục tiêu đạt 10.000 người với doanh số ~ 170M USD.</p>', 'Thứ 2 - Thứ 6'),
(30, '<p>Hỗ trợ xăng dầu và hỗ trợ ăn trưa<br>Phí TeamBuilding<br>Chăm sóc sức khỏe cao cấp<br>Các lớp học tiếng Nhật và hỗ trợ tiếng Nhật<br>Câu lạc bộ thể thao<br>Chuyến đi của công ty - Kiểm tra sức khỏe hàng năm</p>', 'DAC Tech Việt Nam', '51-150', '<p>DAC Tech Việt Nam là công ty thuộc sở hữu của Nhật Bản chuyên phát triển và kiểm thử phần mềm Quảng cáo trên Internet.</p>', 'Thứ 2 - Thứ 6'),
(31, '<p>Chúng tôi có rất nhiều niềm vui &amp; ẩm thực, phong cách pha trộn giữa Châu Âu, Nhật Bản và Việt Nam, đó là môi trường cởi mở, tôn trọng, vui vẻ và có tổ chức;</p><p>Lợi ích của bạn tại CodeComplete Việt Nam:</p><p>• Lương cạnh tranh</p><p>• Thưởng cuối năm</p><p>• Đánh giá lương hai năm một lần (2 lần / năm)</p><p>• Môi trường DevSecOps</p><p>• Kiểm tra sức khoẻ hàng năm</p><p>• Bảo Việt Premium chăm sóc sức khỏe</p><p>• Lớp học tiếng Anh miễn phí với giáo viên nước ngoài</p><p>• Môi trường làm việc quốc tế. (Đội ngũ nhân viên từ nhiều nơi trên thế giới)</p><p>• Các câu lạc bộ bóng đá, cầu lông, bơi lội, bóng bàn.</p><p>• Các hoạt động xây dựng nhóm thú vị. (Hàng tuần, hàng tháng ..)</p><p>• Văn phòng đẹp và rộng rãi với khu thư giãn kiểu quán cà phê</p>', 'CodeComplete Viet Nam', '51-150', '<p>CodeComplete Việt Nam là công ty gồm các chuyên gia phần mềm, phát triển và thử nghiệm các ứng dụng web (front-end và back-end), iOS và Android tại Đà Nẵng. Chúng tôi hợp tác chặt chẽ với các khách hàng ở Nhật Bản và Châu Âu, cũng như phát triển các sản phẩm của riêng mình và chúng tôi cũng có văn phòng tại Tokyo, Nhật Bản. Chúng tôi đang tìm kiếm các kỹ sư và kiểm tra viên có kỹ năng và sáng tạo, yêu thích công nghệ - hãy đến và tham gia với chúng tôi!</p>', 'Thứ 2 - Thứ 6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `experience`
--

CREATE TABLE `experience` (
  `experience_id` int(11) NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `end_time` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `experience_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `start_time` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `experience`
--

INSERT INTO `experience` (`experience_id`, `description`, `end_time`, `experience_name`, `start_time`, `account_id`) VALUES
(15, '- Thực hiện dự án với team dùng spring boot framework làm backend\n- Sử dụng Angular framework làm front end\n- Áp dụng bootstrap, Jquery vào dự án', '2/2019', 'Fresher Java tại công ty ABC', '1/2018', 32),
(16, '- Làm việc với team sử dụng framework Laravel để viết dự án MVC\n- Sử dụng SQL Server để làm nơi lưu trữ dữ liệu', 'hiện tại', 'Junior tại công ty FPT', '3/2018', 33),
(17, '- Làm website luyện thi toeic:\n+ Sử dụng Angular framework kết hợp với bootstrap, jquery\n+ Sử dụng nodeJs để viết Api', '1/2020', 'Đồ án tại trường Bách Khoa Đà Nẵng', '9/2019', 34),
(18, '- Làm ứng dụng di động trên nền tảng Android sử dụng ngôn ngữ java', 'hiện tại', 'Junior tại công ty MGM', '1/2018', 35),
(19, '- Tham gia vào team nghiêm cứu về big data, sử dụng ngôn ngữ python và các thư viện hổ trợ cho máy học và trí tuệ nhân tạo', '5/2020', 'Junior tại công ty FPT', '3/2018', 36),
(20, '- Tham vào team làm website sử dụng framework spring boot làm backend và VueJs làm front end có sử dụng bootstrap, html, css, jquery', '5/2020', 'Fresher tại công ty Sun* Inc', '3/2019', 37),
(21, '- Làm việc với team phát triển Backend sử dụng các framework java Spring, Hibernate, Struts, JPA', 'hiện tại', 'Junior tại công ty MGM', '2/2020', 38),
(22, '- Tham gia vào team phát triển website sử dụng framework spring MVC\n- Làm việc với database Sql server\n- Có kinh nghiệm phát triển với ngôn ngữ UML\n- Sử dụng git để quản lý source code', '3/2020', 'Fresher tại công ty Fsot', '3/2018', 39);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `image`
--

CREATE TABLE `image` (
  `image_id` int(11) NOT NULL,
  `image_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_avatar` bit(1) NOT NULL,
  `is_banner` bit(1) NOT NULL,
  `is_thumbnail` bit(1) NOT NULL,
  `account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `image`
--

INSERT INTO `image` (`image_id`, `image_name`, `is_avatar`, `is_banner`, `is_thumbnail`, `account_id`) VALUES
(29, 'framgia-inc-logo1605513688896.jpg', b'1', b'0', b'0', 28),
(30, 'banner-sun1605513697041.jpg', b'0', b'1', b'0', 28),
(31, 'banner-fsoft1605513971350.jpg', b'0', b'1', b'0', 29),
(32, 'fpt-software-logo1605513979942.png', b'1', b'0', b'0', 29),
(33, 'dac-tech-banner1606749925716.jpg', b'0', b'1', b'0', 30),
(34, 'dac-tech-logo1605516147240.png', b'1', b'0', b'0', 30),
(35, 'banner-codecomplete1605517084584.jpg', b'0', b'1', b'0', 31),
(36, 'codecomplete-logo1605517089199.png', b'1', b'0', b'0', 31),
(37, 'nguyen-quang-hai1605535452382.jpg', b'1', b'0', b'0', 32),
(38, 'do-hung-dung1605535559237.jpg', b'1', b'0', b'0', 33),
(39, 'nguyen-tien-linh1605536434579.jpg', b'1', b'0', b'0', 34),
(40, 'luong-xuan-truong1605538069157.jpg', b'1', b'0', b'0', 35),
(41, 'nguyen-tuan-anh1605541175570.jpg', b'1', b'0', b'0', 36),
(42, 'doan-van-hau1605541919141.jpg', b'1', b'0', b'0', 37),
(43, 'nguyen-van-toan1605542757707.jpg', b'1', b'0', b'0', 38),
(44, 'nguyen-cong-phuong1605543611943.jpg', b'1', b'0', b'0', 39);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `job_apply`
--

CREATE TABLE `job_apply` (
  `job_apply_id` int(11) NOT NULL,
  `match_percent` double NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `job_post_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `job_apply`
--

INSERT INTO `job_apply` (`job_apply_id`, `match_percent`, `account_id`, `job_post_id`, `status_id`) VALUES
(4, 35, 32, 22, 6),
(7, 51, 35, 22, 6),
(8, 33, 36, 22, 6),
(9, 31, 37, 22, 6),
(10, 61, 38, 22, 6),
(11, 50, 39, 22, 6),
(14, 0, 33, 22, 7),
(15, 0, 34, 22, 7),
(18, 0, 32, 25, 5),
(19, 0, 33, 25, 5),
(20, 0, 32, 27, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `job_position`
--

CREATE TABLE `job_position` (
  `job_position_id` int(11) NOT NULL,
  `job_position_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `job_position`
--

INSERT INTO `job_position` (`job_position_id`, `job_position_name`) VALUES
(1, 'Front-end Developer'),
(2, 'Back-end Developer'),
(3, 'Java Developer'),
(4, 'PHP Developer'),
(5, '.NET Developer'),
(6, 'NodeJS Developer'),
(7, 'Python Developer'),
(8, 'Devops Engineer'),
(9, 'System Administrator'),
(10, 'IT Support'),
(11, 'iOS Developer'),
(12, 'Android Developer'),
(13, 'React Native Developer'),
(14, 'Technical Leader'),
(15, 'Project Manager'),
(16, 'Product Manager'),
(17, ' Solution Architect');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `job_post`
--

CREATE TABLE `job_post` (
  `job_post_id` int(11) NOT NULL,
  `job_code` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `job_description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `job_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `job_require` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `num_year_experience` int(11) NOT NULL,
  `create_post_time` date DEFAULT NULL,
  `expire_post_time` date DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `job_position_id` int(11) DEFAULT NULL,
  `job_type_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `job_post`
--

INSERT INTO `job_post` (`job_post_id`, `job_code`, `job_description`, `job_title`, `job_require`, `num_year_experience`, `create_post_time`, `expire_post_time`, `account_id`, `job_position_id`, `job_type_id`, `status_id`) VALUES
(22, '#abc111', '<ul><li>Tham gia vào các dự án phần mềm với những doanh nghiệp hàng đầu Nhật Bản</li><li>Phát triển các ứng dụng Web và Web service, tìm hiểu các công nghệ mới</li><li>Tham gia vào thiết kế và review source code</li><li>Tiếp cận và được đào tạo theo mô hình phát triển dự án Agile, Scrum</li><li>Luôn cập nhật tiến độ và thông báo tình trạng công việc trực tiếp tới quản lý dự án</li><li>Phát triển và maintain ứng dụng java, theo yêu cầu nhận từ phía khách hàng</li><li>Nâng cao performance, turning logic, cài đặt các nghiệp vụ mới</li></ul>', 'Java Engineer (Spring, Struts,..)', '<ul><li>Có ít nhất 1 năm kinh nghiệm làm việc với Java</li><li>Có kiến thức java core, design pattern, servlets, javabean, jdbc</li><li>Đã làm việc với framework: Spring, Struts, JSF, J2EE</li><li>Thao tác tốt với một trong các Database: MySQL, PostgreSQL, Oracle, ... sử dụng Hibernate or JPA</li><li>Có thể phát triển Java Web</li><li>Sử dụng code java 8</li><li>Biết Unit test Junit</li><li>Sử dụng tool build: Maven hoặc Gradle</li><li>Có kinh nghiệm làm việc trong các dự án theo mô hình Agile</li><li>Có khả năng làm việc teamwork cũng như làm việc độc lập</li><li>Có thể làm việc dưới áp lực cao về deadline, đảm bảo chất lượng sản phẩm</li></ul>', 1, '2020-11-17', '2020-12-31', 28, 3, 2, 2),
(25, '#fpt123', '<ul><li>Tham gia vào các dự án phần mềm với những doanh nghiệp hàng đầu Nhật Bản</li><li>Phát triển các ứng dụng Web và Web service, tìm hiểu các công nghệ mới</li><li>Tham gia vào thiết kế và review source code</li><li>Tiếp cận và được đào tạo theo mô hình phát triển dự án Agile, Scrum</li><li>Luôn cập nhật tiến độ và thông báo tình trạng công việc trực tiếp tới quản lý dự án</li><li>Phát triển và maintain ứng dụng java, theo yêu cầu nhận từ phía khách hàng</li><li>Nâng cao performance, turning logic, cài đặt các nghiệp vụ mới</li></ul>', 'Java Engineer (Spring, Struts,..)', '<ul><li>Có ít nhất 1 năm kinh nghiệm làm việc với Java</li><li>Có kiến thức java core, design pattern, servlets, javabean, jdbc</li><li>Đã làm việc với framework: Spring, Struts, JSF, J2EE</li><li>Thao tác tốt với một trong các Database: MySQL, PostgreSQL, Oracle, ... sử dụng Hibernate or JPA</li><li>Có thể phát triển Java Web</li><li>Sử dụng code java 8</li><li>Biết Unit test Junit</li><li>Sử dụng tool build: Maven hoặc Gradle</li><li>Có kinh nghiệm làm việc trong các dự án theo mô hình Agile</li><li>Có khả năng làm việc teamwork cũng như làm việc độc lập</li><li>Có thể làm việc dưới áp lực cao về deadline, đảm bảo chất lượng sản phẩm</li></ul>', 1, '2020-11-30', '2020-12-30', 29, 3, 2, 2),
(26, '#dac123', '<ul><li>Tham gia vào các dự án phần mềm với những doanh nghiệp hàng đầu Nhật Bản</li><li>Phát triển các ứng dụng Web và Web service, tìm hiểu các công nghệ mới</li><li>Tham gia vào thiết kế và review source code</li><li>Tiếp cận và được đào tạo theo mô hình phát triển dự án Agile, Scrum</li><li>Luôn cập nhật tiến độ và thông báo tình trạng công việc trực tiếp tới quản lý dự án</li><li>Phát triển và maintain ứng dụng java, theo yêu cầu nhận từ phía khách hàng</li><li>Nâng cao performance, turning logic, cài đặt các nghiệp vụ mới</li></ul>', 'Java Engineer (Spring, Struts,..)', '<ul><li>Có ít nhất 1 năm kinh nghiệm làm việc với Java</li><li>Có kiến thức java core, design pattern, servlets, javabean, jdbc</li><li>Đã làm việc với framework: Spring, Struts, JSF, J2EE</li><li>Thao tác tốt với một trong các Database: MySQL, PostgreSQL, Oracle, ... sử dụng Hibernate or JPA</li><li>Có thể phát triển Java Web</li><li>Sử dụng code java 8</li><li>Biết Unit test Junit</li><li>Sử dụng tool build: Maven hoặc Gradle</li><li>Có kinh nghiệm làm việc trong các dự án theo mô hình Agile</li><li>Có khả năng làm việc teamwork cũng như làm việc độc lập</li><li>Có thể làm việc dưới áp lực cao về deadline, đảm bảo chất lượng sản phẩm</li></ul>', 1, '2020-11-30', '2020-12-30', 30, 3, 2, 2),
(27, '#codecomplete123', '<ul><li>Tham gia vào các dự án phần mềm với những doanh nghiệp hàng đầu Nhật Bản</li><li>Phát triển các ứng dụng Web và Web service, tìm hiểu các công nghệ mới</li><li>Tham gia vào thiết kế và review source code</li><li>Tiếp cận và được đào tạo theo mô hình phát triển dự án Agile, Scrum</li><li>Luôn cập nhật tiến độ và thông báo tình trạng công việc trực tiếp tới quản lý dự án</li><li>Phát triển và maintain ứng dụng java, theo yêu cầu nhận từ phía khách hàng</li><li>Nâng cao performance, turning logic, cài đặt các nghiệp vụ mới</li></ul>', 'Java Engineer (Spring, Struts,..)', '<ul><li>Có ít nhất 1 năm kinh nghiệm làm việc với Java</li><li>Có kiến thức java core, design pattern, servlets, javabean, jdbc</li><li>Đã làm việc với framework: Spring, Struts, JSF, J2EE</li><li>Thao tác tốt với một trong các Database: MySQL, PostgreSQL, Oracle, ... sử dụng Hibernate or JPA</li><li>Có thể phát triển Java Web</li><li>Sử dụng code java 8</li><li>Biết Unit test Junit</li><li>Sử dụng tool build: Maven hoặc Gradle</li><li>Có kinh nghiệm làm việc trong các dự án theo mô hình Agile</li><li>Có khả năng làm việc teamwork cũng như làm việc độc lập</li><li>Có thể làm việc dưới áp lực cao về deadline, đảm bảo chất lượng sản phẩm</li></ul>', 1, '2020-11-30', '2020-12-30', 31, 3, 2, 2),
(31, 'sdf', '<ul><li>Tham gia vào các dự án phần mềm với những doanh nghiệp hàng đầu Nhật Bản</li><li>Phát triển các ứng dụng Web và Web service, tìm hiểu các công nghệ mới</li><li>Tham gia vào thiết kế và review source code</li><li>Tiếp cận và được đào tạo theo mô hình phát triển dự án Agile, Scrum</li><li>Luôn cập nhật tiến độ và thông báo tình trạng công việc trực tiếp tới quản lý dự án</li><li>Phát triển và maintain ứng dụng java, theo yêu cầu nhận từ phía khách hàng</li><li>Nâng cao performance, turning logic, cài đặt các nghiệp vụ mới</li></ul>', 'ádf', '<ul><li>Có ít nhất 1 năm kinh nghiệm làm việc với Java</li><li>Có kiến thức java core, design pattern, servlets, javabean, jdbc</li><li>Đã làm việc với framework: Spring, Struts, JSF, J2EE</li><li>Thao tác tốt với một trong các Database: MySQL, PostgreSQL, Oracle, ... sử dụng Hibernate or JPA</li><li>Có thể phát triển Java Web</li><li>Sử dụng code java 8</li><li>Biết Unit test Junit</li><li>Sử dụng tool build: Maven hoặc Gradle</li><li>Có kinh nghiệm làm việc trong các dự án theo mô hình Agile</li><li>Có khả năng làm việc teamwork cũng như làm việc độc lập</li><li>Có thể làm việc dưới áp lực cao về deadline, đảm bảo chất lượng sản phẩm</li></ul>', 0, '2020-12-03', '2020-12-17', 28, 11, 2, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `job_save`
--

CREATE TABLE `job_save` (
  `job_save_id` int(11) NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `job_post_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `job_save`
--

INSERT INTO `job_save` (`job_save_id`, `account_id`, `job_post_id`) VALUES
(28, 32, 25),
(29, 40, 25);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `job_type`
--

CREATE TABLE `job_type` (
  `job_type_id` int(11) NOT NULL,
  `job_type_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `job_type`
--

INSERT INTO `job_type` (`job_type_id`, `job_type_name`) VALUES
(1, 'Bán thời gian'),
(2, 'Nhân viên chính thức'),
(3, 'Thực tập');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_EDITOR'),
(3, 'ROLE_CANDIDATE'),
(4, 'ROLE_EMPLOYER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `skill`
--

CREATE TABLE `skill` (
  `skill_id` int(11) NOT NULL,
  `skill_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `skill`
--

INSERT INTO `skill` (`skill_id`, `skill_name`, `description`, `account_id`) VALUES
(16, 'Các ngôn ngữ đã làm', 'Java, PHP, JavaScript, TypeScript, .Net', 32),
(17, 'Các framework đã làm', 'Spring MVC, Spring boot, Laravel, Angular', 32),
(18, 'Kiến trúc lập trình', 'MVC', 32),
(19, 'Các ngôn ngữ đã làm', 'JavaScript, PHP', 33),
(20, 'Kiến trúc đã làm', 'MVC', 33),
(21, 'Các thư viện, framework đã làm', '- ReactJS, Angular, Bootstrap, Jquery', 34),
(22, 'Thành thạo các thao tác trong android', '- Làm việc với các layout\n- Truyền và nhận dữ liệu giữa các màn hình\n- Lưu trữ dữ liệu\n- Xữ lý đa tiến trình', 35),
(23, 'Các  ngôn ngữ đã làm', 'Java, Python, PHP', 36),
(24, 'Các framework đã làm', 'Spring, Laravel, flask', 36),
(25, 'Kiến thức nền', '- Biết về Hướng đối tượng\n- Có kiến thức java core, design pattern, servlets, javabean, jdbc', 37),
(26, 'Các framework đã làm', '- Spring, Struts, JSF, J2EE', 37),
(27, 'Kiến trúc lập trình', '- Có hiểu biết về mô hình kiến trúc lập trình web như: MVC, MVP, MVVM', 38),
(28, 'Các ngôn ngữ lập trình đã làm', '- Java, PHP, .Net, JavaScript', 38),
(29, 'Kiến thức nền', '- Hiểu về lập trình hướng tượng\n- Có kiến thức về các thuật toán trong lập trình', 39),
(30, 'Quy trình quản lý dự án', 'Các quy trình quản lý dự án như Agile, V-model', 39),
(31, 'Các framework đã làm ', 'Laravel, express, spring', 39);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status`
--

CREATE TABLE `status` (
  `status_id` int(11) NOT NULL,
  `status_name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `status`
--

INSERT INTO `status` (`status_id`, `status_name`) VALUES
(1, 'Đang chờ phê duyệt'),
(2, 'Đã phê duyệt'),
(3, 'Từ chối'),
(4, 'Hết hạn'),
(5, 'Hồ sơ đang chờ xử lý'),
(6, 'Hồ sơ phù hợp'),
(7, 'Hồ sơ bị từ chối');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_id`),
  ADD UNIQUE KEY `UK_gex1lmaqpg0ir5g1f5eftyaa1` (`username`),
  ADD KEY `FK9lna4d7ow9qbs27m5psafys58` (`address_id`);

--
-- Chỉ mục cho bảng `account_role`
--
ALTER TABLE `account_role`
  ADD PRIMARY KEY (`account_id`,`role_id`),
  ADD KEY `FKrs2s3m3039h0xt8d5yhwbuyam` (`role_id`);

--
-- Chỉ mục cho bảng `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`);

--
-- Chỉ mục cho bảng `candidate_resume`
--
ALTER TABLE `candidate_resume`
  ADD PRIMARY KEY (`account_id`),
  ADD KEY `FKisek3hjf7lxapos2x4q59cumh` (`job_position_id`),
  ADD KEY `FK7ryrar73mg19r71jbfjqti0v5` (`job_type_id`);

--
-- Chỉ mục cho bảng `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`education_id`),
  ADD KEY `FKq4l9t7bima2cfay9ckpqmj5xm` (`account_id`);

--
-- Chỉ mục cho bảng `employer_resume`
--
ALTER TABLE `employer_resume`
  ADD PRIMARY KEY (`account_id`);

--
-- Chỉ mục cho bảng `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`experience_id`),
  ADD KEY `FK4d0fiw3emcap2s8oq8fi6rsy0` (`account_id`);

--
-- Chỉ mục cho bảng `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`image_id`),
  ADD KEY `FK37umbgqe9rxw10adl0vjah5a7` (`account_id`);

--
-- Chỉ mục cho bảng `job_apply`
--
ALTER TABLE `job_apply`
  ADD PRIMARY KEY (`job_apply_id`),
  ADD KEY `FKhskd43pcx7kw6ljcjbvqfvbfi` (`status_id`),
  ADD KEY `FK31kfjcd8ps082xkywltacodgr` (`account_id`),
  ADD KEY `FKj4iffou8ea3npgkppxeg7wy6k` (`job_post_id`);

--
-- Chỉ mục cho bảng `job_position`
--
ALTER TABLE `job_position`
  ADD PRIMARY KEY (`job_position_id`);

--
-- Chỉ mục cho bảng `job_post`
--
ALTER TABLE `job_post`
  ADD PRIMARY KEY (`job_post_id`),
  ADD KEY `FKcb9pnukliavduxih489fe81ru` (`job_position_id`),
  ADD KEY `FKaoqvusfx5mxccdvbjdg7mc9uv` (`job_type_id`),
  ADD KEY `FKsgrje83k92bce37n15ghu64lm` (`status_id`),
  ADD KEY `FK9shj7oluo1sycxhhmo3qbtycv` (`account_id`);

--
-- Chỉ mục cho bảng `job_save`
--
ALTER TABLE `job_save`
  ADD PRIMARY KEY (`job_save_id`),
  ADD KEY `FKqwiphlrhhbbagjaovuvki890t` (`account_id`),
  ADD KEY `FKgxj61u8a82it4hcic2nv9u7n5` (`job_post_id`);

--
-- Chỉ mục cho bảng `job_type`
--
ALTER TABLE `job_type`
  ADD PRIMARY KEY (`job_type_id`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Chỉ mục cho bảng `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`skill_id`),
  ADD KEY `FKl6bfh0dgaslwp0bigvefl9yvp` (`account_id`);

--
-- Chỉ mục cho bảng `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`status_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT cho bảng `address`
--
ALTER TABLE `address`
  MODIFY `address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `education`
--
ALTER TABLE `education`
  MODIFY `education_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT cho bảng `experience`
--
ALTER TABLE `experience`
  MODIFY `experience_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `image`
--
ALTER TABLE `image`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT cho bảng `job_apply`
--
ALTER TABLE `job_apply`
  MODIFY `job_apply_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `job_position`
--
ALTER TABLE `job_position`
  MODIFY `job_position_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `job_post`
--
ALTER TABLE `job_post`
  MODIFY `job_post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `job_save`
--
ALTER TABLE `job_save`
  MODIFY `job_save_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT cho bảng `job_type`
--
ALTER TABLE `job_type`
  MODIFY `job_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `skill`
--
ALTER TABLE `skill`
  MODIFY `skill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `status`
--
ALTER TABLE `status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FK9lna4d7ow9qbs27m5psafys58` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `account_role`
--
ALTER TABLE `account_role`
  ADD CONSTRAINT `FK1f8y4iy71kb1arff79s71j0dh` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `FKrs2s3m3039h0xt8d5yhwbuyam` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Các ràng buộc cho bảng `candidate_resume`
--
ALTER TABLE `candidate_resume`
  ADD CONSTRAINT `FK7ryrar73mg19r71jbfjqti0v5` FOREIGN KEY (`job_type_id`) REFERENCES `job_type` (`job_type_id`),
  ADD CONSTRAINT `FKisek3hjf7lxapos2x4q59cumh` FOREIGN KEY (`job_position_id`) REFERENCES `job_position` (`job_position_id`),
  ADD CONSTRAINT `FKm9iyfjl3g3w8bm5pnml40k78o` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `education`
--
ALTER TABLE `education`
  ADD CONSTRAINT `FKq4l9t7bima2cfay9ckpqmj5xm` FOREIGN KEY (`account_id`) REFERENCES `candidate_resume` (`account_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `employer_resume`
--
ALTER TABLE `employer_resume`
  ADD CONSTRAINT `FKfn0tc3c3p9m9585j0uwxrteu` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `experience`
--
ALTER TABLE `experience`
  ADD CONSTRAINT `FK4d0fiw3emcap2s8oq8fi6rsy0` FOREIGN KEY (`account_id`) REFERENCES `candidate_resume` (`account_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `FK37umbgqe9rxw10adl0vjah5a7` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `job_apply`
--
ALTER TABLE `job_apply`
  ADD CONSTRAINT `FK31kfjcd8ps082xkywltacodgr` FOREIGN KEY (`account_id`) REFERENCES `candidate_resume` (`account_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKhskd43pcx7kw6ljcjbvqfvbfi` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  ADD CONSTRAINT `FKj4iffou8ea3npgkppxeg7wy6k` FOREIGN KEY (`job_post_id`) REFERENCES `job_post` (`job_post_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `job_post`
--
ALTER TABLE `job_post`
  ADD CONSTRAINT `FK9shj7oluo1sycxhhmo3qbtycv` FOREIGN KEY (`account_id`) REFERENCES `employer_resume` (`account_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKaoqvusfx5mxccdvbjdg7mc9uv` FOREIGN KEY (`job_type_id`) REFERENCES `job_type` (`job_type_id`),
  ADD CONSTRAINT `FKcb9pnukliavduxih489fe81ru` FOREIGN KEY (`job_position_id`) REFERENCES `job_position` (`job_position_id`),
  ADD CONSTRAINT `FKsgrje83k92bce37n15ghu64lm` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

--
-- Các ràng buộc cho bảng `job_save`
--
ALTER TABLE `job_save`
  ADD CONSTRAINT `FKgxj61u8a82it4hcic2nv9u7n5` FOREIGN KEY (`job_post_id`) REFERENCES `job_post` (`job_post_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKqwiphlrhhbbagjaovuvki890t` FOREIGN KEY (`account_id`) REFERENCES `candidate_resume` (`account_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `skill`
--
ALTER TABLE `skill`
  ADD CONSTRAINT `FKl6bfh0dgaslwp0bigvefl9yvp` FOREIGN KEY (`account_id`) REFERENCES `candidate_resume` (`account_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
