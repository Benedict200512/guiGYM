-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2025 at 08:50 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `membership_gym`
--

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `action` varchar(200) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `user_id`, `action`, `date`) VALUES
(1, 1053, 'Created User Record with ID No. 1054', '2025-05-25 23:45:25'),
(14, 1053, 'Created Membership with ID No. 3', '2025-05-26 01:01:43'),
(15, 1053, 'Updated user with ID No. 1054', '2025-05-26 01:36:39'),
(16, 1053, 'Updated user with ID No. 1054', '2025-05-26 01:37:58'),
(17, 1053, 'Created Membership with ID No. 4', '2025-05-26 02:48:19');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_coach`
--

CREATE TABLE `tbl_coach` (
  `coach_id` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `specialty` varchar(100) DEFAULT NULL,
  `experience_years` int(11) DEFAULT NULL,
  `contact_number` varchar(15) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_coach`
--

INSERT INTO `tbl_coach` (`coach_id`, `full_name`, `specialty`, `experience_years`, `contact_number`, `status`) VALUES
(1, 'Mike Bustamante \r\n', 'Strength & Conditioning\r\n', 5, '09123456789', 'Married'),
(2, 'Johnrey Cilin\r\n', 'Weight Loss Coaching\r\n', 3, '09789456123', 'Single'),
(3, 'Hitchean Lisondra\r\n', 'Yoga & Mindfulness\r\n', 2, '09753273587', 'Married');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_membership`
--

CREATE TABLE `tbl_membership` (
  `membership_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `workout_id` int(11) NOT NULL,
  `m_status` varchar(20) NOT NULL,
  `m_start_date` date NOT NULL,
  `m_end_date` date NOT NULL,
  `m_cost` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_membership`
--

INSERT INTO `tbl_membership` (`membership_id`, `user_id`, `workout_id`, `m_status`, `m_start_date`, `m_end_date`, `m_cost`) VALUES
(3, 1054, 2, 'Active', '2025-05-26', '2025-06-26', 5000.00),
(4, 1054, 5, 'Active', '2025-05-26', '2025-06-26', 5000.00);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `user_id` int(20) NOT NULL,
  `user_firstname` varchar(50) NOT NULL,
  `user_lastname` varchar(50) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_contact` varchar(20) NOT NULL,
  `user_username` varchar(50) NOT NULL,
  `user_password` varchar(150) NOT NULL,
  `user_usertype` varchar(50) NOT NULL,
  `user_status` varchar(50) NOT NULL,
  `user_security_question` varchar(50) NOT NULL,
  `user_security_answer` varchar(50) NOT NULL,
  `user_image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`user_id`, `user_firstname`, `user_lastname`, `user_email`, `user_contact`, `user_username`, `user_password`, `user_usertype`, `user_status`, `user_security_question`, `user_security_answer`, `user_image`) VALUES
(1053, 'BENEDICT', 'ALICANTE', 'ben@gmail.com', '12345678988', 'benedok1', 'TPjFdtSRSioqWM8jDGPQqEuRwby23sDJU3dVC3aWWEQ=', 'ADMIN', 'Active', 'What is your favorite food?', 'TRVuECsANcSuizdirkzjZDHEN0ba2YdPse2vWnoVHN0=', 'Undecided'),
(1054, 'ADOK', 'ALICANTE', 'adok@gmail.com', '12312312315', 'ADOK', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'USER', 'Active', 'What is your favorite color?', 'sfUaUR8doM00i4+FmNsy5hy5Y+X8aeK0FIW/mVkO11o=', 'src/userimages/RobloxScreenShot20250117_213623523.png');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_workout`
--

CREATE TABLE `tbl_workout` (
  `workout_id` int(11) NOT NULL,
  `coach_id` int(11) DEFAULT NULL,
  `workout_name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `difficulty_level` varchar(50) DEFAULT NULL,
  `duration_minutes` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_workout`
--

INSERT INTO `tbl_workout` (`workout_id`, `coach_id`, `workout_name`, `description`, `difficulty_level`, `duration_minutes`) VALUES
(1, 1, 'Full Body Blast\r\n', 'A high-intensity workout for all areas	\r\n', 'Hard', 45),
(2, 1, 'Beginner Dumbbell Strength\r\n', 'A simple strength routine using light to moderate ...\r\n', 'Beginner', 30),
(3, 1, 'Push-Pull Split\r\n', 'A two-day strength plan focusing on \"push\" (chest, shoulders, triceps) and \"pull\" (back, biceps) muscles.\r\n', 'Intermediate', 60),
(4, 2, 'Fat Burn HIIT\r\n', 'A high-intensity interval training session with short bursts of cardio and bodyweight exercises designed to spike heart rate and maximize calorie burn.\r\n', 'Intermediate', 30),
(5, 2, 'Quick Cardio Blast\r\n', 'Fast-paced workout featuring jumping jacks, mountain climbers, and burpees for a full-body cardio session. Great for burning fat in a short time.\r\n', 'Beginner', 20),
(6, 2, 'Metabolic Meltdown\r\n', 'A mix of strength and cardio circuits that keeps your metabolism elevated long after the workout ends. Includes kettlebell swings, squats, and sprints.\r\n', 'Advanced', 45),
(7, 3, 'Stress Relief Yoga\r\n', 'Slow-paced, restorative poses focused on deep breathing and body awareness to reduce stress and tension.\r\n', 'Custom', 30),
(8, 3, 'Power Yoga Burn\r\n', 'A dynamic yoga sequence with faster transitions and strength-based poses to increase heart rate and tone muscles.\r\n', 'Intermediate', 40),
(9, 3, 'Mindful Mobility Flow\r\n', 'Combines gentle yoga movements and mindful breathing to increase joint mobility and mental clarity.\r\n', 'Beginner', 25);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `userid` (`user_id`);

--
-- Indexes for table `tbl_coach`
--
ALTER TABLE `tbl_coach`
  ADD PRIMARY KEY (`coach_id`);

--
-- Indexes for table `tbl_membership`
--
ALTER TABLE `tbl_membership`
  ADD PRIMARY KEY (`membership_id`),
  ADD KEY `workout_id` (`workout_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `tbl_workout`
--
ALTER TABLE `tbl_workout`
  ADD PRIMARY KEY (`workout_id`),
  ADD KEY `coach_id` (`coach_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tbl_coach`
--
ALTER TABLE `tbl_coach`
  MODIFY `coach_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbl_membership`
--
ALTER TABLE `tbl_membership`
  MODIFY `membership_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `user_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1055;

--
-- AUTO_INCREMENT for table `tbl_workout`
--
ALTER TABLE `tbl_workout`
  MODIFY `workout_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `userid` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`);

--
-- Constraints for table `tbl_membership`
--
ALTER TABLE `tbl_membership`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  ADD CONSTRAINT `workout_id` FOREIGN KEY (`workout_id`) REFERENCES `tbl_workout` (`workout_id`);

--
-- Constraints for table `tbl_workout`
--
ALTER TABLE `tbl_workout`
  ADD CONSTRAINT `coach_id` FOREIGN KEY (`coach_id`) REFERENCES `tbl_coach` (`coach_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
