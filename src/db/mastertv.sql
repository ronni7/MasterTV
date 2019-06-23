-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 23 Cze 2019, 20:52
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
  `hyperlink` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `channel`
--

INSERT INTO `channel` (`channelid`, `hyperlink`) VALUES
(1, 'link'),
(2, 'link2'),
(3, 'link3');

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
(35),
(35),
(35);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `movie`
--

CREATE TABLE `movie` (
  `movieid` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `length_in_minutes` int(11) NOT NULL,
  `minimum_age` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `start_at_time` varchar(255) DEFAULT NULL,
  `channelid` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `movie`
--

INSERT INTO `movie` (`movieid`, `description`, `file_name`, `length_in_minutes`, `minimum_age`, `title`, `start_at_time`, `channelid`) VALUES
(33, 'Frodo gets ring,goes mad, runs through Middlearth to destroy it', 'lotr1.mp4', 192, 7, 'Lord Of The Rings: The Fellowship Of The Ring', '12:00', 1),
(34, 'Frodo has ring, Theoden says \'Where was Gondor x100 times, LMAO', 'lotr2.mp4', 215, 7, 'Lord Of The Rings: The Two Towers', '13:00', 1),
(35, 'Frodo steps into Mordor finally, Aragorn is going to be king wtf', 'lotr3.mp4', 292, 7, 'Lord Of The Rings: The Fellowship Of The Ring', '17:00', 1),
(11, 'Description', 'movie11111111.mp4', 292, 13, 'Movie 1', NULL, NULL);

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
(23, 'admin@admin.com', 'admin', 'admin', 'Admin1', '$2a$10$xFCb3N1551dfovj2gpsvm.nIu1QOQEPHsFGcMmjGAzOab0ixdQ3tK', 2, 0, 'dzik');

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
