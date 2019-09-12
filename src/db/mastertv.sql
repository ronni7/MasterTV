-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 12 Wrz 2019, 21:24
-- Wersja serwera: 10.1.37-MariaDB
-- Wersja PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `mastertv`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `channel`
--

CREATE TABLE `channel` (
  `channelid` int(11) NOT NULL,
  `hyperlink` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `channel`
--

INSERT INTO `channel` (`channelid`, `hyperlink`, `name`) VALUES
(1, 'http://127.0.0.1:8080/MChannel', 'Filmy'),
(2, 'http://127.0.0.1:8080/MChannel', 'Telenowele'),
(3, 'http://127.0.0.1:8080/InnyKanal', 'Studenci uczacy sie do sesji...');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(77),
(77),
(77);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `movie`
--

CREATE TABLE `movie` (
  `movieid` int(11) NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci,
  `file_name` text CHARACTER SET utf32 COLLATE utf32_polish_ci,
  `length_in_minutes` int(11) NOT NULL,
  `minimum_age` int(11) NOT NULL,
  `title` text CHARACTER SET utf32 COLLATE utf32_polish_ci,
  `start_at_time` text CHARACTER SET utf32 COLLATE utf32_polish_ci,
  `channelid` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `movie`
--

INSERT INTO `movie` (`movieid`, `description`, `file_name`, `length_in_minutes`, `minimum_age`, `title`, `start_at_time`, `channelid`) VALUES
(11, 'Przykladowy Opis', 'nazwapliku1.mp4', 292, 13, 'tytul', '11:00', NULL),
(64, 'Frodo gets ring,goes mad, runs through Middlearth to destroy it', 'lotr1.mp4', 192, 7, 'Lord Of The Rings: The Fellowship Of The Ring', '13:00', 1),
(65, 'Frodo has ring, Theoden says \'Where was Gondor x100 times, LMAO', 'lotr2.mp4', 215, 7, 'Lord Of The Rings: The Two Towers', '15:15', 1),
(66, 'Frodo steps into Mordor finally, Aragorn is going to be king wtf', 'lotr3.mp4', 292, 7, 'Lord Of The Rings: The Fellowship Of The Ring', '19:10', 1),
(68, 'Harry Potter has been living an ordinary life, constantly abused by his surly and cold aunt and uncle, Vernon and Petunia Dursley and bullied by their spoiled son Dudley since the death of his parents ten years prior. His life changes on the day of his eleventh birthday when he receives a letter of acceptance into Hogwarts School of Witchcraft and Wizardry, delivered by a half-giant named Rubeus Hagrid after previous letters had been destroyed by Harry\'s Uncle Vernon and his Aunt Petunia. Hagrid explains Harry\'s hidden past as the wizard son of James and Lily Potter, who were a wizard and witch respectively, and how they were murdered by the most evil and powerful dark wizard of all time, Lord Voldemort, which resulted in the one-year-old Harry being sent to live with his aunt and uncle. Voldemort was not only unable to kill Harry, but his powers were also destroyed in the process, forcing him into exile and sparking Harry\'s immense fame among the magical community.', 'lotr1.mp4', 192, 7, 'Harry Potter And THe Philosophers of the stone', '12:00', 2),
(69, 'Harry Potter spends the summer with The Dursleys without receiving letters from his Hogwarts friends. In his room, Harry meets Dobby, a house-elf who warns him of a peril that will take shape if he returns to Hogwarts. Dobby reveals that he intercepted his friends\' letters, and destroys a cake in order to prevent his return to school. The Dursleys lock Harry up, but Ron Weasley and his older twin brothers, Fred and George, rescue him in their father\'s flying Ford Anglia.', 'lotr2.mp4', 215, 7, 'Harry Potter and the Chamber of Secrets', '15:15', 2),
(70, 'Harry Potter has been spending another dissatisfying summer with The Dursleys. When Harry\'s Aunt Marge insults his parents, he loses his temper and silently wills her to bloat up and float away. Fed up, Harry then flees the Dursleys with his luggage. The Knight Bus delivers Harry to the Leaky Cauldron, where he is pardoned by Minister of Magic Cornelius Fudge for using magic outside of Hogwarts. After reuniting with his best friends Ron Weasley and Hermione Granger, Harry learns that Sirius Black, a convicted supporter of the dark wizard Lord Voldemort, has escaped Azkaban prison and intends to kill Harry.', 'lotr3.mp4', 292, 7, 'Harry Potter and the Prisoner of Azkaban', '19:10', 2),
(71, 'bbbbbbbbbbbbb', 'filmtest1.mp4', 222, 7, 'aaaa', '14:30', NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`userid`, `email`, `login`, `name`, `nickname`, `password`, `role`, `sex`, `surname`) VALUES
(1, 'email@johnny.com', 'login', 'imie', 'nick', '$2a$10$hx5YeD31soTUtYtQLzQwuOCLYcltHex40HG4jfsqa6Q26CIIoSRGe', 0, 0, 'nazwisko'),
(23, 'admin@admin.com', 'admin', 'admin', 'Admin1', '$2a$10$xFCb3N1551dfovj2gpsvm.nIu1QOQEPHsFGcMmjGAzOab0ixdQ3tK', 2, 0, 'dzik'),
(62, 'email@email.com', 'ADMINISTRATOR', 'Admi', 'ADMINISTRATOR', '$2a$10$8T9BK8LN6ppm7dv08cRHdODoQAoVS8oR/va2.E9Dy1NLjkHEO9fUe', 2, 0, 'Nistrator'),
(63, 'email@email.com', 'Podw?adny Admina', 'Mariusz', 'Podwladny', '$2a$10$c8w2Kx648527oIZucXmuvO2iwQLl/aQX76EF3rc8cb6kkp909T8Gq', 2, 1, 'Hasterok');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `channel`
--
ALTER TABLE `channel`
  ADD PRIMARY KEY (`channelid`);

--
-- Indeksy dla tabeli `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movieid`),
  ADD KEY `FKel6nc447yyy1isawdwcg7jqef` (`channelid`);

--
-- Indeksy dla tabeli `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
