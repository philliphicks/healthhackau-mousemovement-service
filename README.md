# Mouse Movement Service

## Synopsis

Simple spring boot based service providing a REST API (JSON) to store/manage/serve data relating to mouse videos being processed for movement.

## Getting started

### Prerequisites

- Install Java 8 (and add it to your PATH etc.)
- Install maven 3+
- Install MySQL

### Running Locally

From the root project dir, run:

```
mvn
```

### Object Model

A database should be created automatically called `mousemovement` with 3 tables: video, snippet & tags.
Video - contains the filename and location e.g. directory/url of the full length video
Snippet - contains the filename, location and time related information of snippets (a small clip of a video that relates to movement picked up by the CV image processing)
Tags - contains descriptions, status and author data about snippets.

## API

The API is JSON based and can be used by the presentation tier to fetch/add/delete (CRUD) any of the object model data.

### Examples

Fetch all videos
Request (GET):
```
http://localhost:8080/api/videos/
```
Response:
```
[
    {
        "id": 1,
        "filename": "CLIP_20151023-130726.mp4",
        "directory": "/opt/data/lib/",
        "snippets": [
            {
                "id": 2,
                "filename": "movement-snippet-1.mp4",
                "directory": "http://mousemovement.org/data/1/snippet/2",
                "status": "PROCESSED",
                "startTime": 1476568920000,
                "endTime": 1476568935000,
                "duration": 15,
                "tags": [
                    {
                        "id": 2,
                        "description": "SLEEPING",
                        "added": 1476572400000,
                        "author": "mel"
                    }
                ]
            },
            {
                "id": 1,
                "filename": "movement-snippet-1.mp4",
                "directory": "http://mousemovement.org/data/1/snippet/1",
                "status": "IN_REVIEW",
                "startTime": 1476568800000,
                "endTime": 1476568815000,
                "duration": 15,
                "tags": [
                    {
                        "id": 1,
                        "description": "EPILEPTIC_FIT",
                        "added": 1476572400000,
                        "author": "william"
                    }
                ]
            }
        ]
    },
    {
        "id": 2,
        "filename": "CLIP_20151023-140722.mp4",
        "directory": "http://mousemovement.edu/data/",
        "snippets": [
            {
                "id": 3,
                "filename": "movement-snippet-1.mp4",
                "directory": "/opt/data/video/1/snippet/1/",
                "status": "NEEDS_REVIEW",
                "startTime": 1476568830000,
                "endTime": 1476568860000,
                "duration": 30,
                "tags": [
                    {
                        "id": 3,
                        "description": "SCREEN_FLICKER",
                        "added": 1476572400000,
                        "author": "william"
                    }
                ]
            }
        ]
    },
    {
        "id": 3,
        "filename": "CLIP_20160412-163125.mp4",
        "directory": "../data/example/",
        "snippets": [ ]
    }
]
```

Fetch one video with all related snippets and their tags)
Request (GET):
```
http://localhost:8080/api/video/1
```
Response:
```
{
    "id": 1,
    "filename": "CLIP_20151023-130726.mp4",
    "directory": "/opt/data/lib/",
    "snippets": [
        {
            "id": 1,
            "filename": "movement-snippet-1.mp4",
            "directory": "http://mousemovement.org/data/1/snippet/1",
            "status": "IN_REVIEW",
            "startTime": 1476568800000,
            "endTime": 1476568815000,
            "duration": 15,
            "tags": [
                {
                    "id": 1,
                    "description": "EPILEPTIC_FIT",
                    "added": 1476572400000,
                    "author": "william"
                }
            ]
        },
        {
            "id": 2,
            "filename": "movement-snippet-1.mp4",
            "directory": "http://mousemovement.org/data/1/snippet/2",
            "status": "PROCESSED",
            "startTime": 1476568920000,
            "endTime": 1476568935000,
            "duration": 15,
            "tags": [
                {
                    "id": 2,
                    "description": "SLEEPING",
                    "added": 1476572400000,
                    "author": "mel"
                }
            ]
        }
    ]
}
```

### Running the Tests

```
mvn test
```

### Contributors

Phil Hicks (phillipmarkhicks@gmail.com)