CREATE TABLE `actors` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) DEFAULT NULL,
                          `birth_year` int(4) DEFAULT NULL,
                          `death_year` int(4) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

CREATE TABLE `directors` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) DEFAULT NULL,
                             `birth_year` int(4) DEFAULT NULL,
                             `death_year` int(4) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

CREATE TABLE `movies` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `title` varchar(57) DEFAULT NULL,
                          `year` int(4) DEFAULT NULL,
                          `image` varchar(161) DEFAULT NULL,
                          `runtime` int(4) DEFAULT NULL,
                          `description` varchar(255) DEFAULT NULL,
                          `director_id` int(11) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `movies_FK` (`director_id`),
                          CONSTRAINT `movies_FK` FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

CREATE TABLE `actors_movies` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `movie_id` int(11) NOT NULL,
                                 `actor_id` int(11) NOT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `actors_movies_FK` (`actor_id`),
                                 KEY `actors_movies_FK2` (`movie_id`),
                                 CONSTRAINT `actors_movies_FK` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                 CONSTRAINT `actors_movies_FK2` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;