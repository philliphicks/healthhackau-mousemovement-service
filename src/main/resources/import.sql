INSERT INTO mousemovement.video (filename, directory) VALUES ('CLIP_20151023-130726.mp4', '/opt/data/lib/');
INSERT INTO mousemovement.video (filename, directory) VALUES ('CLIP_20151023-140722.mp4', 'http://mousemovement.edu/data/');
INSERT INTO mousemovement.video (filename, directory) VALUES ('CLIP_20160412-163125.mp4', '../data/example/');
INSERT INTO mousemovement.snippet (video_id, filename, directory, start_time, end_time, duration, status) VALUES (1, 'movement-snippet-1.mp4', 'http://mousemovement.org/data/1/snippet/1', '2016-10-16 09:00:00', '2016-10-16 09:00:15', 15, 'IN_REVIEW');
INSERT INTO mousemovement.snippet (video_id, filename, directory, start_time, end_time, duration, status) VALUES (1, 'movement-snippet-1.mp4', 'http://mousemovement.org/data/1/snippet/2', '2016-10-16 09:02:00', '2016-10-16 09:02:15', 15, 'PROCESSED');
INSERT INTO mousemovement.snippet (video_id, filename, directory, start_time, end_time, duration, status) VALUES (2, 'movement-snippet-1.mp4', '/opt/data/video/1/snippet/1/', '2016-10-16 09:00:30', '2016-10-16 09:01:00', 30, 'NEEDS_REVIEW');
INSERT INTO mousemovement.tags (snippet_id, description, added, author) VALUES (1, 'EPILEPTIC_FIT', '2016-10-16 10:00:00', 'william');
INSERT INTO mousemovement.tags (snippet_id, description, added, author) VALUES (2, 'SLEEPING', '2016-10-16 10:00:00', 'mel');
INSERT INTO mousemovement.tags (snippet_id, description, added, author) VALUES (3, 'SCREEN_FLICKER', '2016-10-16 10:00:00', 'william');