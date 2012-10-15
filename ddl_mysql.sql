
    drop table if exists Collection;

    drop table if exists DisplayNames;

    drop table if exists Donor;

    drop table if exists Feedback;

    drop table if exists Issue;

    drop table if exists Location;

    drop table if exists LocationType;

    drop table if exists Product;

    drop table if exists ProductUsage;

    drop table if exists RecordFieldsConfig;

    drop table if exists ReportConfig;

    drop table if exists Request;

    drop table if exists TestResult;

    drop table if exists User;

    create table Collection (
        collectionId bigint not null auto_increment,
        abo varchar(255),
        centerId bigint,
        collectionNumber varchar(255),
        comments varchar(255),
        dateCollected datetime,
        donorNumber varchar(255),
        donorType varchar(255),
        isDeleted integer,
        rhd varchar(255),
        sampleNumber bigint,
        shippingNumber bigint,
        siteId bigint,
        primary key (collectionId)
    ) ENGINE=InnoDB;

    create table DisplayNames (
        formType varchar(255) not null,
        fieldNames varchar(255),
        primary key (formType)
    ) ENGINE=InnoDB;

    create table Donor (
        donorId bigint not null auto_increment,
        address varchar(255),
        age integer,
        birthDate datetime,
        bloodType varchar(255),
        comments varchar(255),
        donorNumber varchar(255),
        firstName varchar(255),
        gender varchar(255),
        isDeleted integer,
        lastName varchar(255),
        primary key (donorId)
    ) ENGINE=InnoDB;

    create table Feedback (
        feedbackId bigint not null auto_increment,
        comment varchar(255),
        datetime datetime not null,
        primary key (feedbackId)
    ) ENGINE=InnoDB;

    create table Issue (
        issueId bigint not null auto_increment,
        comments varchar(255),
        dateIssued datetime,
        isDeleted integer,
        productNumber varchar(255),
        siteId bigint,
        primary key (issueId)
    ) ENGINE=InnoDB;

    create table Location (
        locationId bigint not null auto_increment,
        comments varchar(255),
        isCenter integer,
        isCollectionSite integer,
        isDeleted integer,
        isMobileSite integer,
        isUsageSite integer,
        name varchar(255),
        type bigint,
        primary key (locationId)
    ) ENGINE=InnoDB;

    create table LocationType (
        locationTypeId bigint not null auto_increment,
        comments varchar(255),
        isDeleted integer,
        name varchar(255),
        primary key (locationTypeId)
    ) ENGINE=InnoDB;

    create table Product (
        productId bigint not null auto_increment,
        abo varchar(255),
        collectionNumber varchar(255),
        comments varchar(255),
        dateCollected datetime,
        isDeleted integer,
        isIssued integer,
        productNumber varchar(255),
        rhd varchar(255),
        type varchar(255),
        primary key (productId)
    ) ENGINE=InnoDB;

    create table ProductUsage (
        usageId bigint not null auto_increment,
        comments varchar(255),
        dateUsed datetime,
        hospital varchar(255),
        isDeleted integer,
        productNumber varchar(255),
        useIndication varchar(255),
        ward varchar(255),
        primary key (usageId)
    ) ENGINE=InnoDB;

    create table RecordFieldsConfig (
        recordType varchar(255) not null,
        fieldNames varchar(255),
        primary key (recordType)
    ) ENGINE=InnoDB;

    create table ReportConfig (
        reportType varchar(255) not null,
        fieldNames varchar(255),
        primary key (reportType)
    ) ENGINE=InnoDB;

    create table Request (
        requestId bigint not null auto_increment,
        abo varchar(255),
        comments varchar(255),
        dateRequested datetime,
        dateRequired datetime,
        isDeleted integer,
        productType varchar(255),
        quantity integer,
        requestNumber varchar(255),
        rhd varchar(255),
        siteId bigint,
        status varchar(255),
        primary key (requestId)
    ) ENGINE=InnoDB;

    create table TestResult (
        testResultId bigint not null auto_increment,
        abo varchar(255),
        collectionNumber varchar(255),
        comments varchar(255),
        dateCollected datetime,
        dateTested datetime,
        hbv varchar(255),
        hcv varchar(255),
        hiv varchar(255),
        isDeleted integer,
        rhd varchar(255),
        syphilis varchar(255),
        primary key (testResultId)
    ) ENGINE=InnoDB;

    create table User (
        userId bigint not null auto_increment,
        comments varchar(255),
        contactNumber varchar(255),
        emailId varchar(255),
        isDeleted integer,
        name varchar(255),
        password varchar(255),
        type varchar(255),
        username varchar(255),
        primary key (userId)
    ) ENGINE=InnoDB;
