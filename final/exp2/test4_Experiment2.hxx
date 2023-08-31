#ifndef module_struct_h
#define module_struct_h

#ifndef rti_me_cpp_hxx
#include "rti_me_cpp.hxx"
#endif

#ifdef NDDS_USER_DLL_EXPORT
#if (defined(RTI_WIN32) || defined(RTI_WINCE))
/* If the code is building on Windows, start exporting symbols. */
#undef NDDSUSERDllExport
#define NDDSUSERDllExport __declspec(dllexport)
#endif
#else
#undef NDDSUSERDllExport
#define NDDSUSERDllExport
#endif

struct space_inner_ASeq;
class space_inner_ATypeSupport;
class space_inner_ADataWriter;
class space_inner_ADataReader;
class space_inner_A
{
  public:
    typedef struct space_inner_ASeq Seq;
    typedef space_inner_ATypeSupport TypeSupport;
    typedef space_inner_ADataWriter DataWriter;
    typedef space_inner_ADataReader DataReader;

    CDR_Int16 i1 = 10;

};

extern const char *space_inner_ATYPENAME;

REDA_DEFINE_SEQUENCE_STRUCT(space_inner_ASeq, space_inner_A);

REDA_DEFINE_SEQUENCE_IN_C(space_inner_ASeq,space_inner_A);

NDDSUSERDllExport extern RTI_BOOL
space_inner_A_initialize(space_inner_A* sample)
{
    CDR_Primitive_init_Int16(&sample->i1);


    return RTI_TRUE;
}

NDDSUSERDllExport extern RTI_BOOL
space_inner_A_finalize(space_inner_A* sample)
{
    UNUSED_ARG(sample);
    return RTI_TRUE;
}

#ifdef NDDS_USER_DLL_EXPORT
#if (defined(RTI_WIN32) || defined(RTI_WINCE))
/* If the code is building on Windows, stop exporting symbols. */
#undef NDDSUSERDllExport
#define NDDSUSERDllExport
#endif
#endif

#endif /* no_module */