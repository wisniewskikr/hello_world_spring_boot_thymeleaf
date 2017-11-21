SPRING BOOT + THYMELEAF + LDAP


Example application which stores user`s name in LDAP.
Preconditions:
- LDAP server: OpenLDAP;
- LDAP browser: Apache Directory Studio


Differences vs basic:
- class UidService: this class saves and loads user uid (unique identifier);
- class LdapService: this class saves and loads user`s name in LDAP.