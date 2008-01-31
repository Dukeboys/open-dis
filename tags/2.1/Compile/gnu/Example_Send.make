# C Console Executable Makefile autogenerated by premake
# Don't edit this file! Instead edit `premake.lua` then rerun `make`

ifndef CONFIG
  CONFIG=Debug
endif

ifeq ($(CONFIG),Debug)
  BINDIR := ../../bin
  LIBDIR := ../../lib
  OBJDIR := obj_gnu_Example_Send_debug
  OUTDIR := ../../bin
  CPPFLAGS := -MMD -D "_DEBUG" -I "../.." -I "../../cpp" -I "../../CppUtils" -I "/home/jkgrant/soft/dev/src/projects/DIS/delta3d/ext/inc"
  CFLAGS += $(CPPFLAGS) $(TARGET_ARCH) -g
  CXXFLAGS := $(CFLAGS)
  LDFLAGS += -L$(BINDIR) -L$(LIBDIR) -L"/home/jkgrant/soft/dev/src/projects/DIS/delta3d/ext/lib" -lNL ../../bin/libDIS_debug.so -lpthread -lstdc++
  LDDEPS := ../../bin/libDIS_debug.so
  RESFLAGS := -D "_DEBUG" -I "../.." -I "../../cpp" -I "../../CppUtils" -I "/home/jkgrant/soft/dev/src/projects/DIS/delta3d/ext/inc"
  TARGET := Example_Send_debug
  BLDCMD = $(CC) -o $(OUTDIR)/$(TARGET) $(OBJECTS) $(LDFLAGS) $(RESOURCES) $(TARGET_ARCH)
endif

ifeq ($(CONFIG),Release)
  BINDIR := ../../bin
  LIBDIR := ../../lib
  OBJDIR := obj_gnu_Example_Send
  OUTDIR := ../../bin
  CPPFLAGS := -MMD -I "../.." -I "../../cpp" -I "../../CppUtils" -I "/home/jkgrant/soft/dev/src/projects/DIS/delta3d/ext/inc"
  CFLAGS += $(CPPFLAGS) $(TARGET_ARCH) -O2
  CXXFLAGS := $(CFLAGS)
  LDFLAGS += -L$(BINDIR) -L$(LIBDIR) -s -L"/home/jkgrant/soft/dev/src/projects/DIS/delta3d/ext/lib" -lNL ../../bin/libDIS.so -lpthread -lstdc++
  LDDEPS := ../../bin/libDIS.so
  RESFLAGS := -I "../.." -I "../../cpp" -I "../../CppUtils" -I "/home/jkgrant/soft/dev/src/projects/DIS/delta3d/ext/inc"
  TARGET := Example_Send
  BLDCMD = $(CC) -o $(OUTDIR)/$(TARGET) $(OBJECTS) $(LDFLAGS) $(RESOURCES) $(TARGET_ARCH)
endif

OBJECTS := \
	$(OBJDIR)/main.o \
	$(OBJDIR)/Connection.o \
	$(OBJDIR)/Utils.o \
	$(OBJDIR)/Timer.o \

MKDIR_TYPE := msdos
CMD := $(subst \,\\,$(ComSpec)$(COMSPEC))
ifeq (,$(CMD))
  MKDIR_TYPE := posix
endif
ifeq (/bin/sh.exe,$(SHELL))
  MKDIR_TYPE := posix
endif
ifeq ($(MKDIR_TYPE),posix)
  CMD_MKBINDIR := mkdir -p $(BINDIR)
  CMD_MKLIBDIR := mkdir -p $(LIBDIR)
  CMD_MKOUTDIR := mkdir -p $(OUTDIR)
  CMD_MKOBJDIR := mkdir -p $(OBJDIR)
else
  CMD_MKBINDIR := $(CMD) /c if not exist $(subst /,\\,$(BINDIR)) mkdir $(subst /,\\,$(BINDIR))
  CMD_MKLIBDIR := $(CMD) /c if not exist $(subst /,\\,$(LIBDIR)) mkdir $(subst /,\\,$(LIBDIR))
  CMD_MKOUTDIR := $(CMD) /c if not exist $(subst /,\\,$(OUTDIR)) mkdir $(subst /,\\,$(OUTDIR))
  CMD_MKOBJDIR := $(CMD) /c if not exist $(subst /,\\,$(OBJDIR)) mkdir $(subst /,\\,$(OBJDIR))
endif

.PHONY: clean

$(OUTDIR)/$(TARGET): $(OBJECTS) $(LDDEPS) $(RESOURCES)
	@echo Linking Example_Send
	-@$(CMD_MKBINDIR)
	-@$(CMD_MKLIBDIR)
	-@$(CMD_MKOUTDIR)
	@$(BLDCMD)

clean:
	@echo Cleaning Example_Send
ifeq ($(MKDIR_TYPE),posix)
	-@rm -rf $(OUTDIR)/$(TARGET) $(OBJDIR)
else
	-@if exist $(subst /,\,$(OUTDIR)/$(TARGET)) del /q $(subst /,\,$(OUTDIR)/$(TARGET))
	-@if exist $(subst /,\,$(OBJDIR)) del /q $(subst /,\,$(OBJDIR))
	-@if exist $(subst /,\,$(OBJDIR)) rmdir /s /q $(subst /,\,$(OBJDIR))
endif

$(OBJDIR)/main.o: ../../Example/main.cpp
	-@$(CMD_MKOBJDIR)
	@echo $(notdir $<)
	@$(CXX) $(CXXFLAGS) -o $@ -c $<

$(OBJDIR)/Connection.o: ../../Example/Connection.cpp
	-@$(CMD_MKOBJDIR)
	@echo $(notdir $<)
	@$(CXX) $(CXXFLAGS) -o $@ -c $<

$(OBJDIR)/Utils.o: ../../Example/Utils.cpp
	-@$(CMD_MKOBJDIR)
	@echo $(notdir $<)
	@$(CXX) $(CXXFLAGS) -o $@ -c $<

$(OBJDIR)/Timer.o: ../../Example/Timer.cpp
	-@$(CMD_MKOBJDIR)
	@echo $(notdir $<)
	@$(CXX) $(CXXFLAGS) -o $@ -c $<

-include $(OBJECTS:%.o=%.d)

