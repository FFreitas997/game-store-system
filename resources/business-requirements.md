# Business Requirements Document (BRD)

## Table of Contents

- [Introduction](#introduction)
- [Purpose and Objectives](#purpose-and-objectives)
- [Objectives](#objectives)
- [Game Management](#game-management)
- [User Management](#user-management)
- [Community Interaction](#community-interaction)
- [Wishlist](#wishlist)
- [Game Request](#game-request)
- [User Profile](#user-profile)
- [Security](#security)
- [Notifications](#notifications)
- [UI/UX Features](#uiux-features)
- [Non-functional Requirements](#non-functional-requirements)

## Introduction

This document describes the business requirements for the project Game Store application.

## Purpose and Objectives

1. Create a platform where users can browse, search and interact with games in a virtual store (for example, PlayStation Store).
2. It will include community features like commenting, notifications, wishlist, game request user profiles.
3. This system will provide a backoffice for the admin to manage the store and front office for the users to interact with the games.
4. This system will be secure, user-friendly, and provide a seamless user experience.
5. The system will be scalable, reliable, and available 24/7.
6. The system will be developed using modern technologies and best practices.

**_This document will be updated as the project progresses._**

## Objectives

- Create a user-friendly interface
- Ensure a secure environment
- Community features like commenting and notifications
- Seamless user experience for discovering and interacting with games
- User profiles and wishlist
- Game request feature
- Admin panel for managing the store

## Game Management

These are the requirements for the admin:

- Upload a new game (a new game should have a title, description, supported platform, and image)
- Manage the games (edit, delete)
- Manage the users (blocking or disabling accounts)
- Manage the game requests (approve or reject)

## User Management

These are the requirements for the user:

- Browse the games
- Search for games by title and/or supported platform

## Community Interaction

These are the requirements for the community:

- No Authenticated users feature:
    - Read game information (title, description, supported platform)
    - Read game comments
    - Search for games by title and/or supported platform

- Authenticated users feature:
    - Add a comment to a game
    - Receive notifications
    - Manage notification preferences

- Admin feature:
    - Manage users (block or disable accounts)
    - Manage comments (delete inappropriate comments)

## Wishlist

These are the requirements for the wishlist:

- Add games to the wishlist
- Remove games from the wishlist
- See the games in the wishlist

## Game Request

These are the requirements for the user:
- Request a game to be added to the store
- The user receives a notification when the game request is approved or rejected

These are the requirements for the admin:
- Manage the game requests (approve or reject) and receive new request notifications

## User Profile

These are the requirements for the user profile:

- Manage their profile (email, profile picture, username)
- Change the password
- Delete the account

## Security

- **Authentication**:
  - Secured features: add comments, add games to the wishlist, request games
  - The authentication should be done using **JWT**, **OAuth**, **OpenID Connect**, or similar
- **Authorization**:
    - Role-based access control (**RBAC**): **Admin** and **User** roles
    - Admins should be able to manage the store, comments and users (block or disable accounts)
    - Users should be able to create comments, add games to the wishlist, and request games

## Notifications

- The system should send notifications to the users when:
    - A new game is added to the store
    - A game request is approved or rejected
    - A user receives a new comment in a game they commented on
    - A user receives a new reply to their comment
- The admin should receive notifications when:
    - A new game is requested

## UI/UX Features

- Responsive design (desktop, tablet and mobile)
- User-friendly interface
- Dark mode switch

## Non-functional Requirements

- **Performance**: The system should be able to handle a large number of users without performance issues
- **Scalability**: System architecture should be scalable to handle future growth
- **Reliability**: The system should be reliable and available 24/7
- **Security**: Data should be secure and encrypted, passwords should be hashed, protected against SQL injection, CSRF and XSS attacks
- **Availability**: The system should be available 24/7
- **Localization**: The system should support multiple languages
- **Maintainability**: The system should be easy to maintain and update