DROP TABLE IF EXISTS expressionEval;
 
CREATE TABLE expressionEval (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
  input VARCHAR(250) ,
  output INT 
);
 
/*INSERT INTO expressionEval (input,output) VALUES
  ('100 * 2 + 62', 262),
  ('100 * ( 2 + 12 )', 112),
  ('13 + 2 * 6', 25);*/