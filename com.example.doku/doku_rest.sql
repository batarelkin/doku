-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 08, 2015 at 12:02 PM
-- Server version: 5.0.67
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `doku_rest`
--

-- --------------------------------------------------------

--
-- Table structure for table `test_object`
--

DROP TABLE IF EXISTS `test_object`;
CREATE TABLE IF NOT EXISTS `test_object` (
  `id` int(11) NOT NULL auto_increment,
  `value` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `test_object`
--

INSERT INTO `test_object` (`id`, `value`) VALUES
(1, 'Foo'),
(2, 'Bar');
