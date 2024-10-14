# Cyanea - the personal knowledgement system

## Description

Editor-agnostic system for managing your notes,
created for organizing txt, md, org (etc...) files, 
which are spreaded across your system 

## Components

- a core with embedded H2 db and api for deleting, adding and updating files
- markdown parsers collection
- client, which could be either cli or web-native, or desktop-native or
  even editor-native? like emacs client for cyanea? wtfff loooool :DDDD

## Example usages

### Case 1

```shell
~$ cd ~/.config/alacritty/ && pwd

~/.config/alacritty/
 
~/.c/a/$ touch readme.md

~/.c/a/$ cyanea add readme.md -g 'terminal-configs'

# at this point a new note with the title reciprocated from the header of 
# readme file is created, inside of a group called 'terminal-config' 
```

### Case 2

```shell
~/.e/$ pwd

~/.emacs.d/

# assume you have your emacs config in org babel file

~/.e/$ cyanea add config.org -t 'My Emacs Config' 
```

## Ideas and problems

- designing modular strategy for parsers, as i don't wan't to 
  implement each one on my own by myself X(((
- designing non-web api for clients

