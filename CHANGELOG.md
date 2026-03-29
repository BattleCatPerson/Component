# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.01.30

### Added

- Designed a Clock component
- Designed a CalorieTracker component
- Designed a MediaRater component

## 2026.02.21

### Added

- Designed a proof of concept for CalorieTracker component

### Updated

- Changed design from using Queue to Stack and Map
- Changed design to include a method that gives a table of added objects and also one that can remove the last added food

## 2026.03.06

### Added

- Designed kernel and enhanced interfaces for CalorieTracker component

## 2026.03.29

### Added

- Designed abstract class for CalorieTracker component that implemented secondary methods using kernel methods and Object methods toString(), equals(), and hashCode()

### Updated

- Added requirements to getHighest() and getLowest() secondary methods
- Added kernel methods size() along with getAdditions() and getCalorieMap()

### Removed

- removeLast() kernel method since additions is accessible now
- getTable() secondary method and put it in toString() instead

