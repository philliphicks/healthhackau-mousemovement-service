CREATE DATABASE IF NOT EXISTS mousemovement;
CREATE TABLE
    video
    (
        id bigint NOT NULL AUTO_INCREMENT,
        filename VARCHAR(255) NOT NULL,
        directory VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE
    snippet
    (
        id bigint NOT NULL AUTO_INCREMENT,
        video_id bigint NOT NULL,
        filename VARCHAR(100),
        directory VARCHAR(255),
        start_time DATETIME,
        end_time DATETIME,
        duration INTEGER,
        status VARCHAR(100),
        PRIMARY KEY (id),
        CONSTRAINT snippet_fk FOREIGN KEY (video_id) REFERENCES video (id),
        INDEX snippet_fk (video_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE
    tags
    (
        id bigint NOT NULL AUTO_INCREMENT,
        snippet_id bigint NOT NULL,
        description VARCHAR(255) NOT NULL,
        added DATETIME NOT NULL,
        author VARCHAR(255) NOT NULL,
        PRIMARY KEY (id),
        CONSTRAINT tags_fk FOREIGN KEY (snippet_id) REFERENCES snippet (id),
        INDEX transaction_fk (account_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;