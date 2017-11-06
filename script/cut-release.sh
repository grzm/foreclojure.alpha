#!/usr/bin/env bash

set -eu
set -o pipefail

ZERO_TAG="v0.0"
MAJOR="0"
MINOR="1"

REVISION=$(git --no-replace-objects describe --match "${ZERO_TAG}")
# replace "-" with SPACE in REVISION, and interpret as array
PARTS=(${REVISION//-/ })
INCREMENT="${PARTS[1]}"
VERSION_STRING="${MAJOR}.${MINOR}.${INCREMENT}"
DATE_STRING=$(date +%Y-%m-%d)
COMMIT_MESSAGE="Release v${VERSION_STRING} (${DATE_STRING})"

echo release version: "${VERSION_STRING}"
echo git commit -am '"'"${COMMIT_MESSAGE}"'"'
echo git tag -a '"'"v${VERSION_STRING}"'"' -m '"'"${COMMIT_MESSAGE}"'"'
