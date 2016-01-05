# Makefile template for SQLite Java wrapper

prefix =	/usr/local
CC =		gcc
HOSTCC =	cc
LIBTOOL =	./libtool
SQLITE_INC =	
SQLITE_LIB =	
SQLITE3_INC =	 
SQLITE3_LIB =	-lsqlite3  
SQLITE3_A10N_C =	native/dummy.c
SQLITE3_A10N_O =	dummy.lo
JAVAH =		/usr/lib/jvm/java-8-oracle/bin/javah -jni
JAVA_RUN =	/usr/lib/jvm/java-8-oracle/bin/java
JAVA_FLAGS =	
JAVAC =		/usr/lib/jvm/java-8-oracle/bin/javac -nowarn
JAVAC_FLAGS =	
JAVADOC =	/usr/lib/jvm/java-8-oracle/bin/javadoc
JAVADOCLINK =	http://java.sun.com/javase/6/docs/api
JAR =		/usr/lib/jvm/java-8-oracle/bin/jar
JNIINCLUDE =	-I/usr/lib/jvm/java-8-oracle/include -I/usr/lib/jvm/java-8-oracle/include/linux
INSTALL =	/usr/bin/install -c
JAR_DIR =	/usr/lib/jvm/java-8-oracle/jre/lib/ext
NATIVE_LIB_DIR =	/usr/lib/jvm/java-8-oracle/jre/lib/amd64

CFLAGS=	$(JNIINCLUDE) $(SQLITE_INC) $(SQLITE3_INC) \
	-DHAVE_SQLITE2=0 -DHAVE_SQLITE3=1 \
	-DHAVE_SQLITE_FUNCTION_TYPE=0 \
	-DHAVE_SQLITE_OPEN_AUX_FILE=0 \
	-DHAVE_SQLITE_SET_AUTHORIZER=0 \
	-DHAVE_SQLITE_TRACE=0 \
	-DHAVE_SQLITE_COMPILE=0 \
	-DHAVE_SQLITE_PROGRESS_HANDLER=0 \
	-DHAVE_SQLITE3_MALLOC=1 \
	-DHAVE_SQLITE3_PREPARE_V2=1 \
	-DHAVE_SQLITE3_PREPARE16_V2=1 \
	-DHAVE_SQLITE3_BIND_ZEROBLOB=1 \
	-DHAVE_SQLITE3_CLEAR_BINDINGS=1 \
	-DHAVE_SQLITE3_COLUMN_TABLE_NAME16=1 \
	-DHAVE_SQLITE3_COLUMN_DATABASE_NAME16=1 \
	-DHAVE_SQLITE3_COLUMN_ORIGIN_NAME16=1 \
	-DHAVE_SQLITE3_BIND_PARAMETER_COUNT=1 \
	-DHAVE_SQLITE3_BIND_PARAMETER_NAME=1 \
	-DHAVE_SQLITE3_BIND_PARAMETER_INDEX=1 \
	-DHAVE_SQLITE3_RESULT_ZEROBLOB=1 \
	-DHAVE_SQLITE3_INCRBLOBIO=1 \
	-DHAVE_SQLITE3_KEY=0 \
	-DHAVE_SQLITE3_SHARED_CACHE=1 \
	-DHAVE_SQLITE3_OPEN_V2=1 \
	-DHAVE_SQLITE3_LOAD_EXTENSION=0 \
	-DHAVE_SQLITE3_BACKUPAPI=1 \
	-DHAVE_SQLITE3_PROFILE=1 \
	-DHAVE_SQLITE3_STATUS=1 \
	-DHAVE_SQLITE3_DB_STATUS=1 \
	-DHAVE_SQLITE3_STMT_STATUS=1 \
	-DCANT_PASS_VALIST_AS_CHARPTR=1 -g -O2 

LIBS=	 -lsqlite3   

# Add new suffixes
.SUFFIXES: .java .class .lo .la .jar

#
# Rule to compile `java' files
#
.java.class:
	$(JAVAC) -classpath $(CURDIR) $(JAVAC_FLAGS) $<

CLASSES = \
	SQLite/Authorizer.class \
	SQLite/Backup.class \
	SQLite/BusyHandler.class \
	SQLite/Callback.class \
	SQLite/Database.class \
	SQLite/Exception.class \
	SQLite/Shell.class \
	SQLite/TableResult.class \
	SQLite/Function.class \
	SQLite/FunctionContext.class \
	SQLite/Constants.class \
	SQLite/Trace.class \
	SQLite/Vm.class \
	SQLite/Stmt.class \
	SQLite/Blob.class \
	SQLite/BlobR.class \
	SQLite/BlobW.class \
	SQLite/ProgressHandler.class \
	SQLite/StringEncoder.class \
	SQLite/SQLDump.class \
	SQLite/SQLRestore.class \
	SQLite/Profile.class

COMMON_CLASSES = \
	SQLite/Benchmark.class \
	SQLite/BenchmarkThread.class \
	SQLite/DBDump.class \
	SQLite/JDBC.class \
	SQLite/JDBC2z1/JDBCConnection.class \
	SQLite/JDBC2z1/JDBCStatement.class \
	SQLite/JDBC2z1/JDBCResultSet.class \
	SQLite/JDBC2z1/JDBCResultSetMetaData.class \
	SQLite/JDBC2z1/JDBCDatabaseMetaData.class \
	SQLite/JDBC2z1/JDBCPreparedStatement.class \
	SQLite/JDBC2z1/BatchArg.class \
	SQLite/JDBC2z1/TableResultX.class \
	SQLite/JDBC2z1/DatabaseX.class

JDBC_DATA_SOURCE_CLASSES = \
	SQLite/JDBCDataSource.class \
	SQLite/BenchmarkDataSource.class

JDBC_DRIVER_CLASSES = \
	SQLite/JDBCDriver.class \
	SQLite/BenchmarkDriver.class

JDBC0_CLASSES = $(JDBC_DATA_SOURCE_CLASSES)
JDBC1_CLASSES = $(JDBC_DRIVER_CLASSES)
JDBC2_CLASSES = $(JDBC_DRIVER_CLASSES)
JDBC2x_CLASSES = $(JDBC_DRIVER_CLASSES) $(JDBC_DATA_SOURCE_CLASSES)
JDBC2y_CLASSES = $(JDBC_DRIVER_CLASSES) $(JDBC_DATA_SOURCE_CLASSES)
JDBC2z_CLASSES = $(JDBC_DRIVER_CLASSES) $(JDBC_DATA_SOURCE_CLASSES)
JDBC2z1_CLASSES = $(JDBC_DRIVER_CLASSES) $(JDBC_DATA_SOURCE_CLASSES)

PRIVATE_CLASSES = $(COMMON_CLASSES) $(JDBC2z1_CLASSES)

DOCSRCS = \
	SQLite/Authorizer.java \
	SQLite/Backup.java \
	SQLite/BusyHandler.java \
	SQLite/Callback.java \
	SQLite/Database.java \
	SQLite/Exception.java \
	SQLite/TableResult.java \
	SQLite/Function.java \
	SQLite/FunctionContext.java \
	SQLite/Constants.java \
	SQLite/Trace.java \
	SQLite/Vm.java \
	SQLite/Stmt.java \
	SQLite/Blob.java \
	SQLite/ProgressHandler.java \
	SQLite/StringEncoder.java \
	SQLite/Profile.java

all:	sqlite.jar libsqlite_jni.la

SQLite/Constants.java:	native/mkconst VERSION
	native/mkconst > SQLite/Constants.java

$(CLASSES) $(PRIVATE_CLASSES):	SQLite/Constants.java

META-INF/services/java.sql.Driver:
	mkdir -p META-INF/services
	echo SQLite.JDBCDriver > META-INF/services/java.sql.Driver

sqlite.jar:	$(CLASSES) $(PRIVATE_CLASSES) META-INF/services/java.sql.Driver
	$(JAR) cmf manifest sqlite.jar $(CLASSES) $(PRIVATE_CLASSES)
	case "JDBC2z1" in \
	    JDBC2z*) \
		$(JAR) uf sqlite.jar META-INF/services/java.sql.Driver ; \
		;; \
	esac

native/sqlite_jni.h:	SQLite/Database.class SQLite/Vm.class \
	SQLite/FunctionContext.class SQLite/Stmt.class SQLite/Blob.class \
	SQLite/Backup.class SQLite/Profile.class
	$(JAVAH) -classpath $(CURDIR) -o native/sqlite_jni.h \
	    SQLite.Database SQLite.Vm \
	    SQLite.FunctionContext SQLite.Stmt SQLite.Blob SQLite.Backup \
	    SQLite.Profile

sqlite_jni.lo:	native/sqlite_jni.h native/sqlite_jni.c
	$(LIBTOOL) --mode=compile $(CC) -c $(CFLAGS) native/sqlite_jni.c

$(SQLITE3_A10N_O):	$(SQLITE3_A10N_C)
	$(LIBTOOL) --mode=compile $(CC) -c $(CFLAGS) $(SQLITE3_A10N_C)

libsqlite_jni.la:	sqlite_jni.lo $(SQLITE3_A10N_O)
	$(LIBTOOL) --mode=link $(CC) $(CFLAGS) -o libsqlite_jni.la \
	    sqlite_jni.lo $(SQLITE3_A10N_O) -rpath $(NATIVE_LIB_DIR) \
	    -module -avoid-version $(LIBS)

native/mkconst:	native/mkconst.c
	$(LIBTOOL) --mode=link $(HOSTCC)  $(SQLITE_INC) \
	    $(SQLITE3_INC) -DHAVE_SQLITE2=0 \
	    -DHAVE_SQLITE3=1 -o native/mkconst native/mkconst.c

Makefile:	Makefile.in configure config.status
	./config.status

configure:	configure.in
	autoconf

test:	all
	$(JAVAC) -classpath sqlite.jar:$(CURDIR) $(JAVAC_FLAGS) test.java
	LD_LIBRARY_PATH="$$LD_LIBRARY_PATH:$(CURDIR)/.libs" \
	    $(JAVA_RUN) $(JAVA_FLAGS) -classpath sqlite.jar:$(CURDIR) \
	    -DSQLite.library.path=$(CURDIR)/.libs test

test2:	test
	LD_LIBRARY_PATH="$$LD_LIBRARY_PATH:$(CURDIR)/.libs" \
	    $(JAVA_RUN) $(JAVA_FLAGS) -classpath sqlite.jar:$(CURDIR) \
	    -DSQLite.library.path=$(CURDIR)/.libs test db2

test3:	all
	$(JAVAC) -classpath sqlite.jar:$(CURDIR) $(JAVAC_FLAGS) test3.java
	LD_LIBRARY_PATH="$$LD_LIBRARY_PATH:$(CURDIR)/.libs" \
	    $(JAVA_RUN) $(JAVA_FLAGS) -classpath sqlite.jar:$(CURDIR) \
	    -DSQLite.library.path=$(CURDIR)/.libs test3

testg:	all
	$(JAVAC) -classpath sqlite.jar:$(CURDIR) $(JAVAC_FLAGS) testg.java
	LD_LIBRARY_PATH="$$LD_LIBRARY_PATH:$(CURDIR)/.libs" \
	    $(JAVA_RUN) $(JAVA_FLAGS) -classpath sqlite.jar:$(CURDIR) \
	    -DSQLite.library.path=$(CURDIR)/.libs testg

clean:
	$(RM) SQLite/*.class SQLite/JDBC2z1/*.class *.lo *.la *.o *~ \
	    native/sqlite_jni.h native/mkconst \
	    SQLite/Constants.java \
	    test.class test3.class testg.class sqlite.jar conftest*
	$(RM) -r .libs native/.libs META-INF

distclean:	clean
	$(RM) config.status config.log config.cache Makefile

javadoc:
	$(JAVADOC) -private -nodeprecated -nodeprecatedlist \
	    -link "$(JAVADOCLINK)" \
	    -noindex -nohelp -overview doc/overview.html \
	    -windowtitle "SQLite Java Wrapper" \
	    -doctitle "`cat doc/title.html`" \
	    -bottom '<small>Contact: <a HREF="mailto:chw@ch-werner.de">Christian Werner</a></small>' \
	    -d doc -sourcepath . $(DOCSRCS)
	$(INSTALL) -m 644 test.java doc/test.java
	$(INSTALL) -m 644 test3.java doc/test3.java
	$(INSTALL) -m 644 ChangeLog doc/ChangeLog

install:
	$(INSTALL) -d -m 755 $(DESTDIR)$(JAR_DIR)
	$(INSTALL) -m 644 sqlite.jar $(DESTDIR)$(JAR_DIR)
	$(INSTALL) -d -m 755 $(DESTDIR)$(NATIVE_LIB_DIR)
	$(LIBTOOL) --mode=install $(INSTALL) libsqlite_jni.la \
	    $(DESTDIR)$(NATIVE_LIB_DIR)

uninstall:
	$(RM) $(DESTDIR)$(JAR_DIR)/sqlite.jar
	$(LIBTOOL) --mode=uninstall $(RM) \
	    $(DESTDIR)$(NATIVE_LIB_DIR)/libsqlite_jni.la

