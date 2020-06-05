create table history
(
    secid text not null primary key ,
    trade_date date,
    numtrades decimal,
    open decimal,
    close decimal,
    FOREIGN KEY (secid) REFERENCES securities (secid) ON DELETE CASCADE
);