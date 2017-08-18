INSERT INTO users (email, enabled, password) 
  SELECT 'krzysztof.wisniewski@contractors.roche.com',1,'$2a$10$sE7N.QrtNMRtO8aus6Qu3.s9hGrXCHhCDXqA3QdF0TrF4YiPBYCMO' FROM DUAL
WHERE NOT EXISTS 
  (SELECT email FROM users WHERE email='krzysztof.wisniewski@contractors.roche.com');


INSERT INTO user_roles (email, role) 
  SELECT 'krzysztof.wisniewski@contractors.roche.com','ROLE_ADMIN' FROM DUAL
WHERE NOT EXISTS 
  (SELECT email FROM user_roles WHERE email='krzysztof.wisniewski@contractors.roche.com');