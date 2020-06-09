drop table if exists history;
drop table if exists securities;

create  table securities
(
  id int not null primary key,
  secid text unique,
  regnumber text,
  name text,
  emitent_title text
);

create table history
(
    secid text not null primary key,
    trade_date text,
    numtrades decimal,
    open decimal,
    close decimal,
    FOREIGN KEY (secid) REFERENCES securities (secid) ON DELETE CASCADE
);